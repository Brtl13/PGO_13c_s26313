package com.cw2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

enum Genre {
    Adventure,
    Classic,
    Comics,
    Detective,
    Fantasy,
    Fiction
}
enum Lang {
    English,
    Polish,
    Japanese,
    Ukrainian
}

public class Book {
    private long ID;
    private String name;
    private Genre genre;
    private final ArrayList<Person> authors = new ArrayList<>();
    private Lang language;
    private LocalDate publishDate;
    private int borrowCount;
    private Person borrowedBy;
    public static HashMap<String, Person> borrowers = new HashMap<>();

    public Book(String name, Genre genre, Lang language, LocalDate publishDate, Person author, int borrowCount, Person borrowedBy) {
        setName(name);
        setGenre(genre);
        setLanguage(language);
        setPublishDate(publishDate);
        this.authors.add(author);
        this.borrowCount = borrowCount;
        this.borrowedBy = borrowedBy;
    }

    public Book() {
        borrowCount = 0;
        borrowedBy = null;
    }

    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name field cannot be empty");
        } else {
            this.name = name;
        }
    }

    // Genre
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Language
    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang language) {
        this.language = language;
    }

    //Author
    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthor(Person author) {
        for (int i = 0; i < authors.size(); ++i) {
            if (authors.get(i).getName().equals(author.getName()) && authors.get(i).getSurname().equals(author.getSurname())) {
                throw new RuntimeException("Author is already on the list");
            }
        }
        this.authors.add(author);
    }

    //Publish Date
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public void borrowBook(Person person) {
        if (isAvailable()) {
            String key = person.getSurname() + " " + person.getName();
            if (borrowers.containsKey(key)) {
                throw new RuntimeException("Can not borrow more than one book at a time");
            } else {
                borrowCount++;
                borrowedBy = person;
                borrowers.put(key, person);
            }
        }
        else {
            throw new RuntimeException("Book is not available");
        }
    }

    public void placeBack(Person person) {
        if (!isAvailable()) {
            borrowedBy = null;
            borrowers.remove(person.getSurname() + " " + person.getName());
        }
        else {
            throw new RuntimeException("Book is not rented");
        }
    }

    protected String listAuthors() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < authors.size(); ++i) {
            if (i > 0) result.append(", ");
            result.append(authors.get(i).getSurname());
            result.append(" ");
            result.append(authors.get(i).getName());
        }
        return result.toString();
    }

    public String toString() {
        String bar = "\n=========================================================================";
        StringBuilder result = new StringBuilder();
        result.append("\nBook: \"");
        result.append(name);
        result.append("\" by ");
        result.append(listAuthors());
        result.append(bar);
        result.append("\nGenre: ");
        result.append(genre);
        result.append(" Lang: ");
        result.append(language);
        result.append("\nPublished: ");
        result.append(publishDate);
        result.append(bar);
        result.append("\nStatus: ");
        if (isAvailable()) result.append("Available");
        else {
            result.append("Borrowed by ");
            result.append(borrowedBy.getName());
            result.append(" ");
            result.append(borrowedBy.getSurname());
        }
        result.append("\nBorrow count: ");
        result.append(borrowCount);
        result.append(bar);
        result.append("\n");
        return result.toString();
    }
}

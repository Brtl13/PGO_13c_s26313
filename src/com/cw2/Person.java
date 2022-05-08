package com.cw2;

import java.time.LocalDate;
import java.time.Period;


public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    public final Address address;


    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        this.address = address;

    }

    public Person() {
        address= new Address();
    }

    // Name
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
    // Surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new RuntimeException("Surname field cannot be empty");
        } else {
            this.surname = surname;
        }
    }

    // Date of Birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new RuntimeException("Date of birth field cannot empty");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    // Age
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    Book PublishBook(String name, Genre genre, Lang language, LocalDate publishDate) {
        Book newBook = new Book();
        newBook.setName(name);
        newBook.setGenre(genre);
        newBook.setLanguage(language);
        newBook.setAuthor(this);
        newBook.setPublishDate(publishDate);
        return newBook;
    }
}
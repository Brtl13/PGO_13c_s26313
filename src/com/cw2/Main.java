package com.cw2;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person author1 = new Person();
        author1.setSurname("Tolkien");
        author1.setName("J. R. R.");
        author1.setDateOfBirth(LocalDate.parse("1892-01-03"));
        author1.address.setCountry("GB");
        author1.address.setCity("Oxford");
        author1.address.setStreet("Western Road");
        author1.address.setHouse(15);
        author1.address.setFlat(0);

        Person reader1 = new Person();
        reader1.setSurname("Kryszan");
        reader1.setName("Bartosz");
        reader1.setDateOfBirth(LocalDate.parse("1994-11-07"));
        reader1.address.setCountry("PL");
        reader1.address.setCity("Warszawa");
        reader1.address.setStreet("Kołacińska");
        reader1.address.setHouse(17);
        reader1.address.setFlat(0);

        Person reader2 = new Person();
        reader2.setSurname("John");
        reader2.setName("Karpinsky");
        reader2.setDateOfBirth(LocalDate.parse("1999-05-13"));
        reader2.address.setCountry("US");
        reader2.address.setCity("Chicago");
        reader2.address.setStreet("Grove Avenue");
        reader2.address.setHouse(17);
        reader2.address.setFlat(1);

        Person reader3 = new Person();
        reader3.setSurname("Julian");
        reader3.setName("Tevez");
        reader3.setDateOfBirth(LocalDate.parse("1966-11-03"));
        reader3.address.setCountry("ESP");
        reader3.address.setCity("Madrit");
        reader3.address.setStreet("C. de Canarias");
        reader3.address.setHouse(3);
        reader3.address.setFlat(1);

        Book book1 = author1.PublishBook("Wladca Pierscieni", Genre.Fantasy, Lang.English, LocalDate.parse("1955-01-01"));
        Book book2 = author1.PublishBook("Star Wars", Genre.Comics, Lang.English, LocalDate.parse("1955-01-01"));
        Book book3 = reader1.PublishBook("Miedzy nami jaskiniowcami", Genre.Adventure, Lang.Polish, LocalDate.parse("2022-04-30"));
        book3.setAuthor(reader3);

        book1.borrowBook(reader1);
        //book2.borrowBook(reader1);

        System.out.print(book1.toString());
        boolean isAvail = book1.isAvailable();

        book1.placeBack(reader1);
        isAvail = book1.isAvailable();
        System.out.print(book1.toString());

        book1.borrowBook(reader2);
        System.out.print(book1.toString());

        System.out.print(book3.toString());

    }
}

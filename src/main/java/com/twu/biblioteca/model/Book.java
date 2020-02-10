package com.twu.biblioteca.model;

import java.util.Objects;

public class Book {

    private final String name;
    private final String author;
    private final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void viewInfo() {
        System.out.println(name + " | " + author + " | " + yearPublished); // TODO - Global dependency code smell
    } // TODO - magic literals

    // TODO - breaking convention of using the word "compare" for not a very good reason
    public boolean compareByName(String bookName) { // TODO - compare in java or in most languages will return -1,0,1. yous returns boolean. So very likely, you're not comparing.
        return this.name.equals(bookName);
    }
}

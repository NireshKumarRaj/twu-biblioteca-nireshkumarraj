package com.twu.biblioteca;

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

    public Book(String name) {
        this.name = name;
        String AUTHOR_UNKNOWN = "Unknown";
        int YEAR_UNKNOWN = -1;
        this.author = AUTHOR_UNKNOWN;
        this.yearPublished = YEAR_UNKNOWN;
    }

    public void viewInfo() {
        System.out.println(name + " | " + author + " | " + yearPublished);
    }

    public boolean compareByName(String bookName) {
        return this.name.equals(bookName);
    }
}

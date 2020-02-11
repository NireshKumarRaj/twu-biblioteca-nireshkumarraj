package com.twu.biblioteca.model;

public class Book {

    private final String name;
    private final String author;
    private final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getDetails() {
        final String SEPARATOR = " | ";
        return name + SEPARATOR + author + SEPARATOR + yearPublished;
    }

    public boolean is(String bookName) {
        return this.name.equals(bookName);
    }
}

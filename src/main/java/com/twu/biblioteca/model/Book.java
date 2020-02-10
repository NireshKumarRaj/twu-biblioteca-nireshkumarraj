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

    public void viewInfo() {
        final String SEPARATOR = " | ";
        System.out.println(name + SEPARATOR + author + SEPARATOR + yearPublished); // TODO - Global dependency code smell
    }

    public boolean is(String bookName) {
        return this.name.equals(bookName);
    }
}

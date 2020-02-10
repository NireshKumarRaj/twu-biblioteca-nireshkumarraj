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

    // TODO - magic literals - done
    public void viewInfo() {
        final String SEPARATOR = " | ";
        System.out.println(name + SEPARATOR + author + SEPARATOR + yearPublished); // TODO - Global dependency code smell
    }

    // TODO - breaking convention of using the word "compare" for not a very good reason - done
    public boolean is(String bookName) { // TODO - compare in java or in most languages will return -1,0,1. yous returns boolean. So very likely, you're not comparing. -done
        return this.name.equals(bookName);
    }
}

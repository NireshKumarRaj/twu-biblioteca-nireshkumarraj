package com.twu.biblioteca;

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
        System.out.println(name + " | " + author + " | " + yearPublished);
    }
}

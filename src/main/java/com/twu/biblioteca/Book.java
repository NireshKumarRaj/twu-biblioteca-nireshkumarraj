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
        this.author = "Unknown";
        this.yearPublished = -1;
    }

    public void viewInfo() {
        System.out.println(name + " | " + author + " | " + yearPublished);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, yearPublished);
    }
}

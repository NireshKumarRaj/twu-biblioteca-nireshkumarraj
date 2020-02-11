package com.twu.biblioteca.model;

public class Movie {

    private final String name;
    private final int yearPublished;
    private final String director;
    private final int rating;

    public Movie(String name, int yearPublished, String director, int rating) {
        this.name = name;
        this.yearPublished = yearPublished;
        this.director = director;
        this.rating = rating;
    }

    public String displayDetails() {
        final String SEPARATOR = " | ";
        return name + SEPARATOR + yearPublished + SEPARATOR + director + SEPARATOR + rating;
    }
}

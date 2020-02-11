package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    @Test
    void testShouldBeAbleToDisplayMovieDetails() {
        Movie movie = new Movie("The Social Network", 2010, "Mark", 8);

        String movieDetails = movie.displayDetails();

        String expected = "The Social Network | 2010 | Mark | 8";
        assertEquals(expected, movieDetails);
    }
}
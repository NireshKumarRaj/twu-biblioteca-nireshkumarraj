package com.twu.biblioteca.model;

import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class MovieLibraryTest {

    @Test
    void testShouldCheckIfListOfBooksCanBeDisplayed() {
        Movie movie = new Movie("The Social Network", 2010, "Mark", 8);
        MovieLibrary movieLibrary = new MovieLibrary(List.of(movie));
        UI ui = mock(UI.class);
        movieLibrary.setListener(ui);

        movieLibrary.listAvailableMovies();

        verify(ui, times(1)).display(List.of("The Social Network | 2010 | Mark | 8"));
    }

    @Test
    void testShouldBeAbleToCheckOutAMovie() {
        Movie movie = new Movie("The Social Network", 2010, "Mark", 8);
        MovieLibrary movieLibrary = new MovieLibrary(List.of(movie));
        UI ui = mock(UI.class);
        movieLibrary.setListener(ui);

        movieLibrary.checkout("The Social Network");

        verify(ui, times(1)).display("Thank you! Enjoy the movie");
    }
}
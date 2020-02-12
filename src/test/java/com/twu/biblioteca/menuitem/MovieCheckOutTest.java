package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieCheckOutTest {
    @Test
    void testShouldCheckIfMenuOptionIsReturned() {
        MovieCheckOut movieCheckOut = new MovieCheckOut(mock(MovieLibrary.class));

        String name = movieCheckOut.getName();

        assertEquals("Checkout movie", name);
    }

    @Test
    void testShouldCheckIfMovieCheckOutOptionIsAdded() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        MovieCheckOut movieCheckOut = new MovieCheckOut(movieLibrary);

        movieCheckOut.execute();

        verify(movieLibrary, times(1)).checkout("The Social Network");
    }
}
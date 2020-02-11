package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieListTest {
    @Test
    void testShouldBeAbleToListBooks() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        MovieList movieListMenuItem = new MovieList(movieLibrary);

        movieListMenuItem.execute();

        verify(movieLibrary, times(1)).listAvailableMovies();
    }

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        MovieList movieListMenuItem = new MovieList(movieLibrary);

        String menuItemName = movieListMenuItem.getName();

        assertEquals("List Movies", menuItemName);
    }
}
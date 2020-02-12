package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;
import com.twu.biblioteca.view.InputReceiver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieCheckOutTest {
    @AfterEach
    public void reset() {
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void testShouldCheckIfMenuOptionIsReturned() {
        MovieCheckOut movieCheckOut = new MovieCheckOut(mock(MovieLibrary.class));

        String name = movieCheckOut.getName();

        assertEquals("Checkout movie", name);
    }

    @Test
    void testShouldCheckIfMovieNameIsReceivedAsUserInput() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("The Nexus".getBytes()));
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        MovieCheckOut movieCheckOut = new MovieCheckOut(movieLibrary);

        movieCheckOut.execute();

        verify(movieLibrary, times(1)).checkout("The Nexus");
        System.setIn(inputStream);
    }
}
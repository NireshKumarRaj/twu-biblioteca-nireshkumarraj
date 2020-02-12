package com.twu.biblioteca.menuitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieCheckOutTest {
    @Test
    void testShouldCheckIfMenuOptionIsReturned() {
        MovieCheckOut movieCheckOut = new MovieCheckOut();

        String name = movieCheckOut.getName();

        assertEquals("Checkout movie", name);
    }
}
package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testShouldCheckIfBookDetailsAreDisplayed() { // TODO - names don't read like spec. WHat is info? Even information?
        Book book = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        String details = book.getDetails();

        assertEquals("Pragmatic Programmer | Andy Hunt | 1999", details);
    }

    @Test
    void testShouldCheckIfTwoBooksAreEqualByName() { // TODO - test name not updated.
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        assertTrue(book1.is("Pragmatic Programmer"));
    }

    @Test
    void testShouldCheckIfTwoBooksAreNotEqualByName() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        assertFalse(book1.is("Pragmati Programmer"));
    }

    @Test
    void testShouldCheckIfBookReturnsDetails() {
        Book book = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        String details = book.getDetails();

        assertEquals("Pragmatic Programmer | Andy Hunt | 1999", details);
    }
}
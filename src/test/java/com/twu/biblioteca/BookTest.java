package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void testShouldCheckIfBookDetailsAreDisplayed() { // TODO - names don't read like spec. WHat is info? Even information?
        Book book = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        book.getDetails();

        assertEquals("Pragmatic Programmer | Andy Hunt | 1999\n", outContent.toString());
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
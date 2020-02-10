package com.twu.biblioteca;

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
    void testShouldCheckIfBookInfoIsPrinted() {
        Book book = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        book.viewInfo();

        assertEquals("Pragmatic Programmer | Andy Hunt | 1999", outContent.toString().trim());
    }

    @Test
    void testShouldCheckIfTwoBooksAreEqual() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        assertTrue(book1.compareByName("Pragmatic Programmer"));
    }

    @Test
    void testShouldCheckIfTwoBooksAreNotEqualByName() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        assertFalse(book1.compareByName("Pragmati Programmer"));
    }
}
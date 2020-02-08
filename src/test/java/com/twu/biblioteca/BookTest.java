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
        Book book2 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);

        assertEquals(book1, book2);
    }

    @Test
    void testShouldCheckIfTwoBooksAreEqualByName() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1999);
        Book book2 = new Book("Pragmatic Programmer");

        assertEquals(book1, book2);
    }
}
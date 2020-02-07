package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    @Test
    void testShouldCheckIfOneBookIsViewed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Library library = new Library();

        library.view();

        assertEquals("Pragmatic Programmer", outContent.toString().trim());
        System.setOut(originalOut);
    }
}
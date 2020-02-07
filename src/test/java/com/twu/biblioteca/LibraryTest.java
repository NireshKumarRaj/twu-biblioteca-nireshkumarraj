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

        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        String expected = out1 + "\n" + out2 + "\n" + out3;
        assertEquals(expected, outContent.toString().trim());
        System.setOut(originalOut);
    }

}
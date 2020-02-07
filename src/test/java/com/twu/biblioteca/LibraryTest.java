package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    @Test
    void testShouldCheckIfOneBookIsViewed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = Arrays.asList(book1, book2, book3);
        Library library = new Library(books);

        library.view();

        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        String expected = out1 + "\n" + out2 + "\n" + out3;
        assertEquals(expected, outContent.toString().trim());
        System.setOut(originalOut);
    }

}
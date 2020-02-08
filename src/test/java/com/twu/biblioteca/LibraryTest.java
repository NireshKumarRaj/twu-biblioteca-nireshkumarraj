package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = Arrays.asList(book1, book2, book3);
        library = new Library(books);
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
    }

    @Test
    void testShouldCheckIfOneBookIsViewed() {
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out1 + "\n" + out2 + "\n" + out3;

        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testIfBookCanBeAddedToCheckOutList() {
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out2 + "\n" + out3;

        library.checkout("Pragmatic Programmer");
        library.view();

        assertEquals(expected, outContent.toString().replaceAll("Thank you! Enjoy the book", "").trim());
    }

    @Test
    void testIfUserIsNotifiedUponSuccessFullBookCheckout() {

        library.checkout("Pragmatic Programmer");

        String expected = "Thank you! Enjoy the book";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testIfUserIsNotifiedWhenBookIsNotAvailableInTheLibrary() {

        library.checkout("Pragmati Programmer");

        String expected = "Sorry, that book is not available";
        assertEquals(expected, outContent.toString().trim());
    }
}
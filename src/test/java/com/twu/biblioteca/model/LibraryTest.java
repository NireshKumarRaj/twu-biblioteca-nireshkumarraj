package com.twu.biblioteca.model;

import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryTest {
    private Library library;
    private UI ui;

    @BeforeEach
    void setUp() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = Arrays.asList(book1, book2, book3);
        library = new Library(books);
        ui = mock(UI.class);
        library.setListener(ui);
    }

    @Test
    void testShouldCheckIfOneBookIsViewed() {
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        List<String> availableBooks = library.getAvailableBooks();

        assertEquals(of(out1, out2, out3), availableBooks);
    }

    @Test
    void testIfBookCanBeAddedToCheckOutList() {
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        library.checkout("Pragmatic Programmer");
        List<String> availableBooks = library.getAvailableBooks();

        assertEquals(of(out2, out3), availableBooks);
    }

    @Test
    void testIfUserIsNotifiedUponSuccessFullBookCheckout() {

        library.checkout("Pragmatic Programmer");

        String expected = "Thank you! Enjoy the book";

        verify(ui, times(1)).display(expected);
    }

    @Test
    void testIfUserIsNotifiedWhenBookIsNotAvailableInTheLibrary() {

        library.checkout("Pragmati Programmer");

        String expected = "Sorry, that book is not available";

        verify(ui, times(1)).display(expected);
    }

    @Test
    void testIfUserIsAbleToReturnABook() {
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        library.checkout("Pragmatic Programmer");
        library.returnBook("Pragmatic Programmer");
        List<String> availableBooks = library.getAvailableBooks();

        assertEquals(of(out1, out2, out3), availableBooks);
    }

    @Test
    void testIfUserIsNotifiedUponSuccessFullBookReturn() {
        library.checkout("Pragmatic Programmer");

        library.returnBook("Pragmatic Programmer");

        String expected = "Thank you for returning the book";

        verify(ui, times(1)).display(expected);
    }

    @Test
    void testIfUserIsNotifiedWhenReturnedBookDoesNotBelongToTheLibrary() {
        String expected = "That is not a valid book to return.";

        library.checkout("Pragmatic Programmer");
        library.returnBook("Pragmata Programmer");

        verify(ui, times(1)).display(expected);
    }

    @Test
    void testShouldCheckIfListOfBooksAreReturned() {
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        List<String> availableBooks = library.getAvailableBooks();

        assertEquals(of(out1, out2, out3), availableBooks);
    }

    @Test
    void testShouldCheckIfSuccessMessageOnCheckoutIsDisplayedThroughUI() {
        library.checkout("Pragmatic Programmer");


    }
}
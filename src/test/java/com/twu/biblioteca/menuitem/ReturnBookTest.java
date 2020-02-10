package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

class ReturnBookTest {
    @Test
    void testShouldCheckIfReturnBookIsInvoked() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Agile".getBytes()));
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(library);

        returnBook.execute();

        verify(library, times(1)).returnBook("Agile");
        System.setIn(inputStream);
    }

    @Test
    void testShouldCheckIfReturnBookNameIsReceivedFromUser() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Pragmatic Programmer".getBytes()));
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(library);

        returnBook.execute();

        verify(library, times(1)).returnBook("Pragmatic Programmer");
        System.setIn(inputStream);
    }
}
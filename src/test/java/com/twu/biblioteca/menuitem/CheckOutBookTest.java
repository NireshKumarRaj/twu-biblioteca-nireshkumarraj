package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutBookTest {
    @Test
    void testShouldCheckIfCheckOutIsInvoked() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Agile".getBytes()));
        Library library = mock(Library.class);
        CheckOutBook checkOutBook = new CheckOutBook(library);

        checkOutBook.execute();

        verify(library,times(1)).checkout("Agile");
        System.setIn(inputStream);
    }

    @Test
    void testShouldCheckIfBookNameIsReceivedFromUser() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Pragmatic Programmer".getBytes()));
        Library library = mock(Library.class);
        CheckOutBook checkOutBook = new CheckOutBook(library);

        checkOutBook.execute();

        verify(library,times(1)).checkout("Pragmatic Programmer");
        System.setIn(inputStream);
    }
}
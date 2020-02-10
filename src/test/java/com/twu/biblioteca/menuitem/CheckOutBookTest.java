package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutBookTest {
    @Test
    void testShouldCheckIfCheckOutIsInvoked() {
        Library library = mock(Library.class);
        CheckOutBook checkOutBook = new CheckOutBook(library);

        checkOutBook.execute();

        verify(library,times(1)).checkout("Pragmatic Programmer");
    }
}
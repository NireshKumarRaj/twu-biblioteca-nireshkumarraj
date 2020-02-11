package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListBooksTest {
    @Test
    void testShouldCheckIfBooksAreListed() {
        Library library = mock(Library.class);
        ListBooks listBooks = new ListBooks(library);

        listBooks.execute();

        verify(library, times(1)).listAvailableBooks();
    }
}
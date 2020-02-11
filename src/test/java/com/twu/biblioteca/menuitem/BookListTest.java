package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookListTest {
    @Test
    void testShouldCheckIfBooksAreListed() {
        Library library = mock(Library.class);
        BookList bookList = new BookList(library);

        bookList.execute();

        verify(library, times(1)).listAvailableBooks();
    }

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        Library library = mock(Library.class);
        BookList bookListMenuItem = new BookList(library);

        String menuItemName = bookListMenuItem.getName();

        assertEquals("List Books", menuItemName);
    }
}
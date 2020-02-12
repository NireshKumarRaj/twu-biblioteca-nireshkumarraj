package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CheckedOutBooksTest {

    @Test
    void testShouldCheckIfNameIsAvailable() {
        CheckedOutBooks checkedOutBooksMenuItem = new CheckedOutBooks(mock(Library.class));

        String menuItemName = checkedOutBooksMenuItem.getName();

        assertEquals("List checked out books", menuItemName);
    }

    @Test
    void testShouldCheckIfCheckedOutBooksAreDisplayed() {
        Library library = mock(Library.class);
        CheckedOutBooks checkedOutBooksMenuItem = new CheckedOutBooks(library);

        checkedOutBooksMenuItem.execute();

        verify(library, times(1)).listCheckOutBooks();
    }
}
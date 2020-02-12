package com.twu.biblioteca.menuitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckedOutBooksTest {

    @Test
    void testShouldCheckIfNameIsAvailable() {
        CheckedOutBooks checkedOutBooksMenuItem = new CheckedOutBooks();

        String menuItemName = checkedOutBooksMenuItem.getName();

        assertEquals("List checked out books", menuItemName);
    }
}
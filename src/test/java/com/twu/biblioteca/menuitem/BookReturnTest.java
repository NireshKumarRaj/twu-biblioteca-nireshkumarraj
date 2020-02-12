package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookReturnTest {

    @AfterEach
    public void reset() {
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void testShouldCheckIfReturnBookIsInvoked() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Agile".getBytes()));
        Library library = mock(Library.class);
        BookReturn bookReturn = new BookReturn(library);

        bookReturn.execute();

        verify(library, times(1)).returnBook("Agile");
        System.setIn(inputStream);
    }

    @Test
    void testShouldCheckIfReturnBookNameIsReceivedFromUser() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Pragmatic Programmer".getBytes()));
        Library library = mock(Library.class);
        BookReturn bookReturn = new BookReturn(library);

        bookReturn.execute();

        verify(library, times(1)).returnBook("Pragmatic Programmer");
        System.setIn(inputStream);
    }

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        Library library = mock(Library.class);
        BookReturn bookReturnMenuItem = new BookReturn(library);

        String menuItemName = bookReturnMenuItem.getName();

        assertEquals("Return Book", menuItemName);
    }
}
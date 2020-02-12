package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.InputReceiver;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookCheckOutTest {
    @Test
    void testShouldCheckIfCheckOutIsInvoked() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Agile".getBytes()));
        Library library = mock(Library.class);
        BookCheckOut bookCheckOut = new BookCheckOut(library, new Authenticator());

        bookCheckOut.execute();

        verify(library, times(1)).checkout("Agile");
        System.setIn(inputStream);
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void testShouldCheckIfBookNameIsReceivedFromUser() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Pragmatic Programmer".getBytes()));
        Library library = mock(Library.class);
        BookCheckOut bookCheckOut = new BookCheckOut(library, new Authenticator());

        bookCheckOut.execute();

        verify(library, times(1)).checkout("Pragmatic Programmer");
        System.setIn(inputStream);
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        Library library = mock(Library.class);
        BookCheckOut bookCheckOut = new BookCheckOut(library, new Authenticator());

        String menuItemName = bookCheckOut.getName();

        assertEquals("Checkout", menuItemName);
    }

    @Test
    void testShouldBeAbleToAuthenticateUserBeforeCheckOut() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Pragmatic Programmer".getBytes()));
        Library library = mock(Library.class);
        Authenticator authenticator = mock(Authenticator.class);
        BookCheckOut bookCheckOut = new BookCheckOut(library, authenticator);

        bookCheckOut.execute();

        verify(authenticator, times(1)).authenticate("123-4567", "test1");
        System.setIn(inputStream);
    }
}
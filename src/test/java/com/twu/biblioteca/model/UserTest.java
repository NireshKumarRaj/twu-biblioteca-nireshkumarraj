package com.twu.biblioteca.model;

import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserTest {

    @Test
    void testShouldBeAbleToDisplayUserInformation() {
        UI ui = mock(UI.class);
        User user = new User("name", "email", "+919941980802", "123-4567", "test1");
        user.setListener(ui);

        user.getDetails();

        verify(ui, times(1)).display("Name : name\nEmail : email\nMobile : +919941980802");
    }

    @Test
    void testShouldCheckGivenLibraryNumberAndPasswordAreSame() {
        User user = new User("name", "email", "+919941980802", "123-4567", "test1");

        boolean result = user.is("123-4567", "test1");

        assertTrue(result);
    }
}
package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.Authenticator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoginMenuItemTest {
    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        LoginMenuItem loginMenuItem = new LoginMenuItem(mock(Authenticator.class));

        String name = loginMenuItem.getName();

        assertEquals("Login", name);
    }

    @Test
    void testShouldBeAbleToAuthenticateUser() {
        Authenticator authenticator = mock(Authenticator.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(authenticator, times(1)).authenticate("123-4567", "test1");
    }
}
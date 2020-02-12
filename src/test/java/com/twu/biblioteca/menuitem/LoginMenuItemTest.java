package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Authenticator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
    void testShouldBeAbleToGetUserNameAndPasswordThroughInput() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("156-6578\ntest1".getBytes()));
        Authenticator authenticator = mock(Authenticator.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(authenticator, times(1)).authenticate("156-6578", "test1");
        System.setIn(inputStream);
    }
}
package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Authenticator;
import com.twu.biblioteca.view.InputReceiver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoginMenuItemTest {

    @AfterEach
    public void reset() {
        InputReceiver.getInputReceiver().reset();
    }

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

    @Test
    void testShouldBeAbleToNotifyUponSuccessfulLogin() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("123-4567\ntest1".getBytes()));
        Authenticator authenticator = mock(Authenticator.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);
        when(authenticator.authenticate("123-4567", "test1")).thenReturn(true);

        loginMenuItem.execute();

        verify(authenticator, times(1)).notifyListener("Your login is successful");
        System.setIn(inputStream);
    }

    @Test
    void testShouldBeAbleToNotifyUponFailedLogin() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("156-6578\ntest1".getBytes()));
        Authenticator authenticator = mock(Authenticator.class);
        when(authenticator.authenticate("156-6578", "test1")).thenReturn(false);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(authenticator, times(1)).notifyListener("Sorry! Invalid credentials.");
        System.setIn(inputStream);
    }

    @Test
    void testShouldCheckIfUserLoginIsUpdated() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("123-4567\ntest1".getBytes()));
        Authenticator authenticator = mock(Authenticator.class);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);
        when(authenticator.authenticate("123-4567", "test1")).thenReturn(true);

        loginMenuItem.execute();

        verify(authenticator, times(1)).notifyListener("Your login is successful");
        verify(authenticator, timeout(1)).setUserLogin(true);
        System.setIn(inputStream);
    }
}
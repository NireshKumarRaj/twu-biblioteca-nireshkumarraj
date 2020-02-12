package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Authenticator;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.InputReceiver;
import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

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
        User user = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user));
        UI ui = mock(UI.class);
        authenticator.setListener(ui);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(ui, times(1)).display("Your login is successful");
        System.setIn(inputStream);
    }

    @Test
    void testShouldBeAbleToNotifyUponFailedLogin() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("156-6578\ntest1".getBytes()));
        User user = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user));
        UI ui = mock(UI.class);
        authenticator.setListener(ui);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(ui, times(1)).display("Sorry! Invalid credentials.");
        System.setIn(inputStream);
    }

    @Test
    void testShouldCheckIfUserLoginIsUpdated() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("123-4567\ntest1".getBytes()));

        User user = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user));
        UI ui = mock(UI.class);
        authenticator.setListener(ui);

        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);

        loginMenuItem.execute();

        verify(ui, times(1)).display("Your login is successful");
        System.setIn(inputStream);
    }
}
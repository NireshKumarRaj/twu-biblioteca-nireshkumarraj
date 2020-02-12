package com.twu.biblioteca.model;

import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class AuthenticatorTest {
    @Test
    void testShouldCheckIfUserNameAndPasswordMatched() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user1));
        UI ui = mock(UI.class);
        authenticator.setListener(ui);
        authenticator.authenticate("123-4567", "test1");

        verify(ui, times(1)).setLoggedIn(true);
    }

    @Test
    void testShouldCheckIfUserNameAndPasswordNotMatched() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user1));
        UI ui = mock(UI.class);
        authenticator.setListener(ui);
        authenticator.authenticate("123-4567", "test2");

        verify(ui, times(1)).display("Sorry! Invalid credentials.");
    }
}
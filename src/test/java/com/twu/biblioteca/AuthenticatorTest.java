package com.twu.biblioteca;

import com.twu.biblioteca.model.Authenticator;
import com.twu.biblioteca.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticatorTest {
    @Test
    void testShouldCheckIfUserNameAndPasswordMatched() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user1));

        boolean result = authenticator.authenticate("123-4567", "test1");

        assertTrue(result);
    }

    @Test
    void testShouldCheckIfUserNameAndPasswordNotMatched() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        Authenticator authenticator = new Authenticator(List.of(user1));

        boolean result = authenticator.authenticate("123-4567", "test2");

        assertFalse(result);
    }
}
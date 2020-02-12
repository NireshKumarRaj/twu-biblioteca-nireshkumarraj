package com.twu.biblioteca;

import com.twu.biblioteca.model.Authenticator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticatorTest {
    @Test
    void testShouldCheckIfUserNameAndPasswordMatched() {
        Authenticator authenticator = new Authenticator();

        boolean result = authenticator.authenticate("123-4567", "test1");

        assertTrue(result);
    }

    @Test
    void testShouldCheckIfUserNameAndPasswordNotMatched() {
        Authenticator authenticator = new Authenticator();

        boolean result = authenticator.authenticate("123-4567", "test2");

        assertFalse(result);
    }
}
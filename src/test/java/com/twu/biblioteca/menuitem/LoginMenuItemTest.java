package com.twu.biblioteca.menuitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginMenuItemTest {
    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        LoginMenuItem loginMenuItem = new LoginMenuItem();

        String name = loginMenuItem.getName();

        assertEquals("Login", name);
    }
}
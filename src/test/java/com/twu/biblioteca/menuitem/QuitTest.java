package com.twu.biblioteca.menuitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class QuitTest {

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        Quit quitMenuItem = new Quit();

        String menuItemName = quitMenuItem.getName();

        assertEquals("Quit", menuItemName);
    }
}
package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class QuitTest {

    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        Quit quitMenuItem = new Quit();

        String menuItemName = quitMenuItem.getName();

        assertEquals("Quit", menuItemName);
    }

    @Test
    void testShouldBeAbleToCheckIfInputReceiverIsReset() {
        InputReceiver inputReceiver = InputReceiver.getInputReceiver();
        Quit quitMenuItem = new Quit();

        quitMenuItem.execute();

        assertTrue(inputReceiver.isClosed());
    }
}
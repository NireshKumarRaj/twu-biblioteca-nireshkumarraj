package com.twu.biblioteca.menuitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewUserTest {
    @Test
    void testShouldBeAbleToReturnMenuItemName() {
        ViewUser viewUserMenuItem = new ViewUser();

        String menuItemName = viewUserMenuItem.getName();

        assertEquals("View My Info", menuItemName);
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.menuitem.MenuItem;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MenuTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void testShouldCheckIfMenuIsDisplayed() { // TODO - what's in command line?
        Menu menu = new Menu(Collections.singletonList("List Books"));

        menu.display();

        assertEquals("1. List Books\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuWithMultipleItemsIsDisplayed() {
        Menu menu = new Menu(Arrays.asList("List Books", "Quit"));

        menu.display();

        assertEquals("1. List Books\n2. Quit\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuWithCheckoutOptionIsDisplayed() {
        Menu menu = new Menu(Arrays.asList("List Books", "Checkout", "Quit"));

        menu.display();

        assertEquals("1. List Books\n2. Checkout\n3. Quit\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuListWithMenuItemCanBeCreated() {
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getName()).thenReturn("List Books");
        Menu menu = Menu.createMenuWithMenuItems(List.of(menuItem));

        menu.display();

        String expected = "1. " + menuItem.getName() + "\n\n";
        assertEquals(expected, outContent.toString());
    }
}
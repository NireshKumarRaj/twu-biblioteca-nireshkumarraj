package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void testIfMenuIsDisplayedInCommandLine() {
        Menu menu = new Menu(Collections.singletonList("List Books"));

        menu.display();

        assertEquals("1. List Books", outContent.toString().trim());
    }

    @Test
    void testIfMenuWithMultipleItemsIsDisplayedInCommandLine() {
        Menu menu = new Menu(Arrays.asList("List Books", "Quit"));

        menu.display();

        assertEquals("1. List Books\n2. Quit", outContent.toString().trim());
    }
}
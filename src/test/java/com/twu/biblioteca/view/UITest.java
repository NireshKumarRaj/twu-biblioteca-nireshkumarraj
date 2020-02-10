package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UITest {

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
    void testShouldCheckIfMenuIsDisplayed() {
        Menu menu = mock(Menu.class);
        UI ui = new UI(menu, mock(Library.class));
        when(menu.getMenuOptions()).thenReturn(List.of("List Books", "Quit"));

        ui.showMenu();

        assertEquals("1. List Books\n2. Quit\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfListOfBooksAreDisplayed() {
        Library library = mock(Library.class);
        when(library.getAvailableBooks()).thenReturn(List.of("Pragmatic Programmer | Andy Hunt | 1999"));
        UI ui = new UI(mock(Menu.class), library);

        ui.showBooks();

        assertEquals("1. Pragmatic Programmer | Andy Hunt | 1999", outContent.toString().trim());
    }
}
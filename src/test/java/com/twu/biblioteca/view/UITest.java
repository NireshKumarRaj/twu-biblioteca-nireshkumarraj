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
    void testShouldCheckIfGivenMessageIsPrinted() {
        UI ui = new UI(mock(Menu.class), mock(Library.class));

        ui.display("Thank you and Enjoy the book");

        assertEquals("Thank you and Enjoy the book\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfGivenListIsPrinted() {
        UI ui = new UI(mock(Menu.class), mock(Library.class));

        ui.display(List.of("List Books", "Quit"));

        assertEquals("1. List Books\n2. Quit\n", outContent.toString());
    }
}
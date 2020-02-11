package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class UITest {

    private ByteArrayOutputStream outContent;
    private UI ui;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        ui = new UI(new PrintStream(outContent));
        ui.addModel(mock(Menu.class));
        ui.addModel(mock(Library.class));
    }

    @Test
    void testShouldCheckIfGivenMessageIsPrinted() {
        ui.display("Thank you and Enjoy the book");

        assertEquals("Thank you and Enjoy the book\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfGivenListIsPrinted() {
        ui.display(List.of("List Books", "Quit"));

        assertEquals("1. List Books\n2. Quit\n", outContent.toString());
    }
}
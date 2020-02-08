package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BibliotecaTest {
    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent;
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        bibliotecaApp = new BibliotecaApp();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        originalIn = System.in;
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testShouldCheckIfWelcomeMessageIsPrinted() {
        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", outContent.toString().trim());
    }

    @Test
    public void testIfWelcomeMessageIsDisplayedWhenStartIsInvoked() {
        bibliotecaApp.start();

        assertTrue(outContent.toString().contains("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void testIfLibraryListIsDisplayedWhenStartIsInvoked() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));
        bibliotecaApp.start();

        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";

        String expected = out1 + "\n" + out2 + "\n" + out3;
        assertTrue(outContent.toString().contains(expected));
        System.setIn(inputStream);
    }
}

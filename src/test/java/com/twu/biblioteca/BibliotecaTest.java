package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BibliotecaTest {
    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        bibliotecaApp = new BibliotecaApp();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    public void testShouldCheckIfWelcomeMessageIsPrinted() {
        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", outContent.toString().trim());
    }

    @Test
    public void testIfWelcomeMessageIsDisplayedWhenStartIsInvoked(){
        bibliotecaApp.start();

        assertTrue(outContent.toString().contains("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void testIfLibraryListIsDisplayedWhenStartIsInvoked(){
        bibliotecaApp.start();

        assertTrue(outContent.toString().contains("Pragmatic Programmer\nExtreme Programming\nAgile Programming"));
    }
}

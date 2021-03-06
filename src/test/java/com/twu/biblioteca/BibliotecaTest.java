package com.twu.biblioteca;

import com.twu.biblioteca.controller.InputReceiver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class BibliotecaTest {
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        originalIn = System.in;
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        InputReceiver.getInputReceiver().reset();
    }

}

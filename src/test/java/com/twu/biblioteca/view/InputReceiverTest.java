package com.twu.biblioteca.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReceiverTest {

    @Test
    void testShouldCheckIfUserInputIsReceived() {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Agile".getBytes()));
        InputReceiver inputReceiver = InputReceiver.getInputReceiver();

        String input = inputReceiver.readLine();
        inputReceiver.reset();

        assertEquals("Agile", input);
        System.setIn(inputStream);
        InputReceiver.getInputReceiver().reset();
    }
}
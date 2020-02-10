package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class InputTest {

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        library = mock(Library.class);
    }

    @AfterEach
    void afterEach() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void checkIfUserInputIsReceived() {
        String data = "1\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, mock(Menu.class));

        input.read();

        verify(library, times(1)).view();
    }

    @Test
    void checkIfUserEntersInvalidOption() {
        String data = "6\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, mock(Menu.class));

        input.read();

        String expected = "Enter input: \n"+"Please select a valid option!\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void checkIfUserIsAbleToQuit() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = mock(Menu.class);
        Input input = new Input(library, menu);
        when(menu.isQuit(2)).thenReturn(true);

        input.read();

        assertEquals("Enter input: \n", outContent.toString());
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutOptionAndProceed() {
        String data = "2\nPragmatic Programmer\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, mock(Menu.class));

        input.read();

        verify(library, times(1)).checkout("Pragmatic Programmer");
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutABook() {
        String data = "2\nPragmatic Programmer\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, mock(Menu.class));

        input.read();

        verify(library, times(1)).checkout("Pragmatic Programmer");
    }

    @Test
    void checkIfUserIsAbleToReturnABook() {
        String data = "3\nPragmatic Programmer\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Input input = new Input(library, mock(Menu.class));

        input.read();

        verify(library, times(1)).returnBook("Pragmatic Programmer");
    }

    @Test
    void testIfIsQuitIsUpdatedUponSelectionOfOption() {
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = mock(Menu.class);
        Input input = new Input(library, menu);
        when(menu.isQuit(4)).thenReturn(true);

        input.read();

        assertTrue(input.isQuit());
    }
}
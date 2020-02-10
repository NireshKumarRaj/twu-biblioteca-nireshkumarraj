package com.twu.biblioteca.view;

import com.twu.biblioteca.menuitem.CheckOutBook;
import com.twu.biblioteca.menuitem.ListBooks;
import com.twu.biblioteca.menuitem.Quit;
import com.twu.biblioteca.menuitem.ReturnBook;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


class BibliotecaControllerTest {

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
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void checkIfUserInputIsReceived() {
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ListBooks listBooks = mock(ListBooks.class);
        Quit quit = mock(Quit.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(listBooks, quit));
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);

        bibliotecaController.read();

        verify(listBooks, times(1)).execute();
    }

    @Test
    void checkIfUserEntersInvalidOption() {
        String data = "6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Quit quit = mock(Quit.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(mock(ListBooks.class), quit));
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);

        bibliotecaController.read();

        String expected = "Enter input: \n" + "Please select a valid option!\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void checkIfUserIsAbleToQuit() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ListBooks listBooks = mock(ListBooks.class);
        Quit quit = mock(Quit.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(listBooks, quit));
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);

        bibliotecaController.read();

        verify(quit, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutOptionAndProceed() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBook checkOutBook = mock(CheckOutBook.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(mock(ListBooks.class), checkOutBook, mock(Quit.class)));
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);

        bibliotecaController.read();

        verify(checkOutBook, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToReturnABook() {
        String data = "3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnBook returnBook = mock(ReturnBook.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(mock(ListBooks.class), mock(CheckOutBook.class), returnBook, mock(Quit.class)));
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);

        bibliotecaController.read();

        verify(returnBook, times(1)).execute();
    }

    @Test
    void testIfIsQuitIsUpdatedUponSelectionOfOption() {
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = mock(Menu.class);
        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);
        when(menu.isQuit(4)).thenReturn(true);

        bibliotecaController.read();

        assertTrue(bibliotecaController.isQuit());
    }
}
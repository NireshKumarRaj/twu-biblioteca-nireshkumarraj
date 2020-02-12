package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.menuitem.BookCheckOut;
import com.twu.biblioteca.menuitem.BookList;
import com.twu.biblioteca.menuitem.BookReturn;
import com.twu.biblioteca.menuitem.Quit;
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
import static org.mockito.Mockito.*;


class BibliotecaControllerTest {

    private InputStream originalIn;
    private UI ui;

    @BeforeEach
    void setUp() {
        ui = mock(UI.class);
        when(ui.isLoggedIn()).thenReturn(true);
        originalIn = System.in;
    }

    @AfterEach
    void afterEach() {
        System.setIn(originalIn);
        InputReceiver.getInputReceiver().reset();
    }

    @Test
    void checkIfUserInputIsReceived() {
        String data = "1\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookList bookList = mock(BookList.class);
        Quit quit = mock(Quit.class);
        Menu menu = new Menu(List.of(bookList, quit));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.start();

        verify(bookList, times(1)).execute();
    }

    @Test
    void checkIfUserEntersInvalidOption() {
        String data = "6\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Quit quit = mock(Quit.class);
        Menu menu = new Menu(List.of(mock(BookList.class), quit));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.start();

        String expected = "Please select a valid option!";
        verify(ui, times(1)).display(expected);
    }

    @Test
    void checkIfUserIsAbleToQuit() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookList bookList = mock(BookList.class);
        Quit quit = mock(Quit.class);
        Menu menu = new Menu(List.of(bookList, quit));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.start();

        verify(quit, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutOptionAndProceed() {
        String data = "2\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookCheckOut bookCheckOut = mock(BookCheckOut.class);
        Menu menu = new Menu(List.of(mock(BookList.class), bookCheckOut, mock(Quit.class)));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.start();

        verify(bookCheckOut, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToReturnABook() {
        String data = "3\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookReturn bookReturn = mock(BookReturn.class);
        Menu menu = new Menu(List.of(mock(BookList.class), mock(BookCheckOut.class), bookReturn, mock(Quit.class)));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.start();

        verify(bookReturn, times(1)).execute();
    }

    @Test
    public void testShouldCheckIfWelcomeMessageIsPrinted() {
        Menu menu = mock(Menu.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(outContent);
        UI ui = new UI(outputStream);
        ui.addModel(menu);
        ui.addModel(mock(Library.class));
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.displayWelcomeMessage();

        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckIfUIIsInvoked() {
        BibliotecaController bibliotecaController = new BibliotecaController(mock(Menu.class), ui);

        bibliotecaController.displayWelcomeMessage();

        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        verify(ui, times(1)).display(expected);
    }
}
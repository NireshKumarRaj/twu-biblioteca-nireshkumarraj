package com.twu.biblioteca.view;

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
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
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
        BookList bookList = mock(BookList.class);
        Quit quit = mock(Quit.class);
        Menu menu = new Menu(List.of(bookList, quit));
        BibliotecaController bibliotecaController = new BibliotecaController(menu, mock(UI.class));

        bibliotecaController.readUserInput();

        verify(bookList, times(1)).execute();
    }

    @Test
    void checkIfUserEntersInvalidOption() {
        String data = "6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Quit quit = mock(Quit.class);
        Menu menu = new Menu(List.of(mock(BookList.class), quit));
        UI ui = mock(UI.class);
        menu.setListener(ui);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, mock(UI.class));

        bibliotecaController.readUserInput();

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
        BibliotecaController bibliotecaController = new BibliotecaController(menu, mock(UI.class));

        bibliotecaController.readUserInput();

        verify(quit, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutOptionAndProceed() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookCheckOut bookCheckOut = mock(BookCheckOut.class);
        Menu menu = new Menu(List.of(mock(BookList.class), bookCheckOut, mock(Quit.class)));
        BibliotecaController bibliotecaController = new BibliotecaController(menu, mock(UI.class));

        bibliotecaController.readUserInput();

        verify(bookCheckOut, times(1)).execute();
    }

    @Test
    void checkIfUserIsAbleToReturnABook() {
        String data = "3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookReturn bookReturn = mock(BookReturn.class);
        Menu menu = new Menu(List.of(mock(BookList.class), mock(BookCheckOut.class), bookReturn, mock(Quit.class)));
        BibliotecaController bibliotecaController = new BibliotecaController(menu, mock(UI.class));

        bibliotecaController.readUserInput();

        verify(bookReturn, times(1)).execute();
    }

    @Test
    public void testShouldCheckIfWelcomeMessageIsPrinted() {
        Menu menu = mock(Menu.class);
        UI ui = new UI(menu, mock(Library.class), System.out);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);

        bibliotecaController.displayWelcomeMessage();

        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testShouldCheckIfUIIsInvoked() {
        UI ui = mock(UI.class);
        BibliotecaController bibliotecaController = new BibliotecaController(mock(Menu.class), ui);

        bibliotecaController.displayWelcomeMessage();

        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        verify(ui, times(1)).display(expected);
    }
}
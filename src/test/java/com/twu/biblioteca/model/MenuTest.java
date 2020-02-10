package com.twu.biblioteca.model;

import com.twu.biblioteca.menuitem.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private ListBooks listBooksMenuItem;
    private CheckOutBook checkOutBookMenuItem;
    private Quit quitMenuItem;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        listBooksMenuItem = mock(ListBooks.class);
        when(listBooksMenuItem.getName()).thenReturn("List Books");
        checkOutBookMenuItem = mock(CheckOutBook.class);
        when(checkOutBookMenuItem.getName()).thenReturn("Checkout");
        quitMenuItem = mock(Quit.class);
        when(quitMenuItem.getName()).thenReturn("Quit");
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void testShouldCheckIfMenuIsDisplayed() { // TODO - what's in command line?
        Menu menu = Menu.createMenuWithMenuItems(Collections.singletonList(listBooksMenuItem));

        menu.getMenuOptions();

        assertEquals("1. List Books\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuWithMultipleItemsIsDisplayed() {
        Menu menu = Menu.createMenuWithMenuItems(Arrays.asList(listBooksMenuItem, quitMenuItem));

        menu.getMenuOptions();

        assertEquals("1. List Books\n2. Quit\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuWithCheckoutOptionIsDisplayed() {
        Menu menu = Menu.createMenuWithMenuItems(Arrays.asList(listBooksMenuItem, checkOutBookMenuItem, quitMenuItem));

        menu.getMenuOptions();

        assertEquals("1. List Books\n2. Checkout\n3. Quit\n\n", outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuListWithMenuItemCanBeCreated() {
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getName()).thenReturn("List Books");
        Menu menu = Menu.createMenuWithMenuItems(List.of(menuItem));

        menu.getMenuOptions();

        String expected = "1. " + menuItem.getName() + "\n\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testShouldCheckIfListBooksMenuItemIsInvoked() {
        ListBooks listBooks = mock(ListBooks.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(listBooks));
        int inputFromUser = 1;

        menu.execute(inputFromUser);

        verify(listBooks, times(1)).execute();
    }

    @Test
    void testShouldCheckIfCheckOutMenuItemIsInvoked() {
        CheckOutBook checkOutBook = mock(CheckOutBook.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(mock(ListBooks.class), checkOutBook));
        int inputFromUser = 2;

        menu.execute(inputFromUser);

        verify(checkOutBook, times(1)).execute();
    }

    @Test
    void testShouldCheckIfReturnBookMenuItemIsInvoked() {
        ReturnBook returnBook = mock(ReturnBook.class);
        Menu menu = Menu.createMenuWithMenuItems(List.of(mock(ListBooks.class), mock(CheckOutBook.class), returnBook));
        int inputFromUser = 3;

        menu.execute(inputFromUser);

        verify(returnBook, times(1)).execute();
    }

    @Test
    void testShouldCheckIfInvalidInputIsHandled() {
        List<MenuItem> menuOptions = List.of(mock(ListBooks.class), mock(CheckOutBook.class), mock(ReturnBook.class), mock(Quit.class));
        Menu menu = Menu.createMenuWithMenuItems(menuOptions);
        int inputFromUser = 7;

        menu.execute(inputFromUser);

        String expected = "Please select a valid option!\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testShouldCheckIfMenuOptionsAreReturned() { // TODO - what's in command line?
        Menu menu = Menu.createMenuWithMenuItems(List.of(listBooksMenuItem));

        List<String> menuOptions = menu.getMenuOptions();

        assertEquals(List.of("List Books"), menuOptions);
    }
}
package com.twu.biblioteca.model;

import com.twu.biblioteca.menuitem.*;
import com.twu.biblioteca.view.UI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {

    private ListBooks listBooksMenuItem;
    private CheckOutBook checkOutBookMenuItem;
    private Quit quitMenuItem;
    private UI ui;

    @BeforeEach
    void setUp() {
        listBooksMenuItem = mock(ListBooks.class);
        when(listBooksMenuItem.getName()).thenReturn("List Books");
        checkOutBookMenuItem = mock(CheckOutBook.class);
        when(checkOutBookMenuItem.getName()).thenReturn("Checkout");
        quitMenuItem = mock(Quit.class);
        when(quitMenuItem.getName()).thenReturn("Quit");
        ui = mock(UI.class);
    }

    @Test
    void testShouldCheckIfMenuIsDisplayed() { // TODO - what's in command line?
        Menu menu = new Menu(Collections.singletonList(listBooksMenuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books"));
    }

    @Test
    void testShouldCheckIfMenuWithMultipleItemsIsDisplayed() {
        Menu menu = new Menu(Arrays.asList(listBooksMenuItem, quitMenuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books", "Quit"));
    }

    @Test
    void testShouldCheckIfMenuWithCheckoutOptionIsDisplayed() {
        Menu menu = new Menu(Arrays.asList(listBooksMenuItem, checkOutBookMenuItem, quitMenuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books", "Checkout", "Quit"));
    }

    @Test
    void testShouldCheckIfMenuListWithMenuItemCanBeCreated() {
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getName()).thenReturn("List Books");
        Menu menu = new Menu(List.of(menuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books"));

    }

    @Test
    void testShouldCheckIfListBooksMenuItemIsInvoked() {
        ListBooks listBooks = mock(ListBooks.class);
        Menu menu = new Menu(List.of(listBooks));
        int inputFromUser = 1;

        menu.execute(inputFromUser);

        verify(listBooks, times(1)).execute();
    }

    @Test
    void testShouldCheckIfCheckOutMenuItemIsInvoked() {
        CheckOutBook checkOutBook = mock(CheckOutBook.class);
        Menu menu = new Menu(List.of(mock(ListBooks.class), checkOutBook));
        int inputFromUser = 2;

        menu.execute(inputFromUser);

        verify(checkOutBook, times(1)).execute();
    }

    @Test
    void testShouldCheckIfReturnBookMenuItemIsInvoked() {
        ReturnBook returnBook = mock(ReturnBook.class);
        Menu menu = new Menu(List.of(mock(ListBooks.class), mock(CheckOutBook.class), returnBook));
        int inputFromUser = 3;

        menu.execute(inputFromUser);

        verify(returnBook, times(1)).execute();
    }

    @Test
    void testShouldCheckIfInvalidInputIsHandled() {
        List<MenuItem> menuOptions = List.of(mock(ListBooks.class), mock(CheckOutBook.class), mock(ReturnBook.class), mock(Quit.class));
        Menu menu = new Menu(menuOptions);
        UI ui = mock(UI.class);
        menu.setListener(ui);
        int inputFromUser = 7;

        menu.execute(inputFromUser);

        String expected = "Please select a valid option!";
        verify(ui, times(1)).display(expected);
    }
}
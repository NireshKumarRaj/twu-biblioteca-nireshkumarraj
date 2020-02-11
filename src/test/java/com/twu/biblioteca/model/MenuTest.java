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

    private BookList bookListMenuItem;
    private BookCheckOut bookCheckOutMenuItem;
    private Quit quitMenuItem;
    private UI ui;

    @BeforeEach
    void setUp() {
        bookListMenuItem = mock(BookList.class);
        when(bookListMenuItem.getName()).thenReturn("List Books");
        bookCheckOutMenuItem = mock(BookCheckOut.class);
        when(bookCheckOutMenuItem.getName()).thenReturn("Checkout");
        quitMenuItem = mock(Quit.class);
        when(quitMenuItem.getName()).thenReturn("Quit");
        ui = mock(UI.class);
    }

    @Test
    void testShouldCheckIfMenuIsDisplayed() { // TODO - what's in command line?
        Menu menu = new Menu(Collections.singletonList(bookListMenuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books"));
    }

    @Test
    void testShouldCheckIfMenuWithMultipleItemsIsDisplayed() {
        Menu menu = new Menu(Arrays.asList(bookListMenuItem, quitMenuItem));
        menu.setListener(ui);

        menu.displayMenuOptions();

        verify(ui, times(1)).display(List.of("List Books", "Quit"));
    }

    @Test
    void testShouldCheckIfMenuWithCheckoutOptionIsDisplayed() {
        Menu menu = new Menu(Arrays.asList(bookListMenuItem, bookCheckOutMenuItem, quitMenuItem));
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
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(List.of(bookList));
        int inputFromUser = 1;

        menu.execute(inputFromUser);

        verify(bookList, times(1)).execute();
    }

    @Test
    void testShouldCheckIfCheckOutMenuItemIsInvoked() {
        BookCheckOut bookCheckOut = mock(BookCheckOut.class);
        Menu menu = new Menu(List.of(mock(BookList.class), bookCheckOut));
        int inputFromUser = 2;

        menu.execute(inputFromUser);

        verify(bookCheckOut, times(1)).execute();
    }

    @Test
    void testShouldCheckIfReturnBookMenuItemIsInvoked() {
        BookReturn bookReturn = mock(BookReturn.class);
        Menu menu = new Menu(List.of(mock(BookList.class), mock(BookCheckOut.class), bookReturn));
        int inputFromUser = 3;

        menu.execute(inputFromUser);

        verify(bookReturn, times(1)).execute();
    }

    @Test
    void testShouldCheckIfInvalidInputIsHandled() {
        List<MenuItem> menuOptions = List.of(mock(BookList.class), mock(BookCheckOut.class), mock(BookReturn.class), mock(Quit.class));
        Menu menu = new Menu(menuOptions);
        UI ui = mock(UI.class);
        menu.setListener(ui);
        int inputFromUser = 7;

        menu.execute(inputFromUser);

        String expected = "Please select a valid option!";
        verify(ui, times(1)).display(expected);
    }
}
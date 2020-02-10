package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.util.List;

public class UI {

    private Menu menu;
    private Library library;

    public UI(Menu menu, Library library) {
        this.menu = menu;
        this.library = library;
    }

    public void showMenu() {
        List<String> menuOptions = menu.getMenuOptions();
        for (int menuItemNumber = 1; menuItemNumber <= menuOptions.size(); menuItemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((menuItemNumber) + SEPARATOR + menuOptions.get(menuItemNumber - 1));
        }
    }

    public void showBooks() {
        List<String> books = library.getAvailableBooks();
        for (int bookNumber = 1; bookNumber <= books.size(); bookNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((bookNumber) + SEPARATOR + books.get(bookNumber - 1));
        }
    }
}

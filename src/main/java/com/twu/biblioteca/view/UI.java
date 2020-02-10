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

    private void show(List<String> toDisplayList) {
        for (int itemNumber = 1; itemNumber <= toDisplayList.size(); itemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((itemNumber) + SEPARATOR + toDisplayList.get(itemNumber - 1));
        }
    }

    public void showMenu() {
        List<String> menuOptions = menu.getMenuOptions();
        show(menuOptions);
    }

    public void showBooks() {
        List<String> books = library.getAvailableBooks();
        show(books);
    }

}

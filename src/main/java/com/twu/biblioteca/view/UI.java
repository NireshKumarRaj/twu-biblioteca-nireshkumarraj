package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Menu;

import java.util.List;

public class UI {

    private Menu menu;

    public UI(Menu menu) {
        this.menu = menu;
    }

    public void display(String message) {
        System.out.println(message);
    }

    public void showMenu() {
        List<String> menuOptions = menu.getMenuOptions();
        for (int menuItemNumber = 1; menuItemNumber <= menuOptions.size(); menuItemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((menuItemNumber) + SEPARATOR + menuOptions.get(menuItemNumber - 1));
        }
    }
}

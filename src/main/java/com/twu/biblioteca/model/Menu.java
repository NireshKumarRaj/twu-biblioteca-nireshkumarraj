package com.twu.biblioteca.model;

import com.twu.biblioteca.menuitem.MenuItem;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private List<MenuItem> menuOptions;

    public Menu(List<MenuItem> menuOptions) {
        this.menuOptions = menuOptions;
    }

    @Deprecated
    public static Menu createMenuWithMenuItems(List<MenuItem> menuOptions) {
        return new Menu(menuOptions);
    }

    public List<String> getMenuOptions() {
        for (int menuItemNumber = 1; menuItemNumber <= menuOptions.size(); menuItemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((menuItemNumber) + SEPARATOR + menuOptions.get(menuItemNumber - 1).getName());
        }
        System.out.println();
        return menuOptions.stream().map(MenuItem::getName).collect(Collectors.toList());
    }

    public boolean isQuit(int input) {
        return input == menuOptions.size();
    }

    public void execute(int inputFromUser) {
        final String INVALID_OPTION_MESSAGE = "Please select a valid option!";
        if (inputFromUser > menuOptions.size()){
            System.out.println(INVALID_OPTION_MESSAGE);
            return;
        }
        menuOptions.get(inputFromUser - 1).execute();
    }
}

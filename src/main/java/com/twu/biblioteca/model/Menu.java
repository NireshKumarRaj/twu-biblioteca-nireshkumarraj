package com.twu.biblioteca.model;

import com.twu.biblioteca.menuitem.MenuItem;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private List<String> menuList;
    private List<MenuItem> menuOptions;

    public Menu(List<String> menuList) {
        this.menuList = menuList;
    }

    public static Menu createMenuWithMenuItems(List<MenuItem> menuOptions) {
        Menu menu = new Menu(menuOptions.stream().map(MenuItem::getName).collect(Collectors.toList()));
        menu.menuOptions = menuOptions;
        return menu;
    }

    public void display() {
        for (int menuItemNumber = 1; menuItemNumber <= menuList.size(); menuItemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((menuItemNumber) + SEPARATOR + menuList.get(menuItemNumber - 1));
        }
        System.out.println();
    }

    public boolean isQuit(int input) {
        return input == menuList.size();
    }
}

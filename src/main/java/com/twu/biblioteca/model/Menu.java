package com.twu.biblioteca.model;

import java.util.List;

public class Menu {

    private List<String> menuList;

    public Menu(List<String> menuList) {
        this.menuList = menuList;
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

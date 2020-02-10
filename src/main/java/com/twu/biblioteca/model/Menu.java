package com.twu.biblioteca.model;

import java.util.List;

public class Menu {

    private List<String> menuList;

    public Menu(List<String> menuList) {
        this.menuList = menuList;
    }

    public void display() {
        int menuItemNumber = 1; // TODO - inn't this maintained in a simple for loop?
        for (String menuItem : menuList) { // TODO - why not use a simple for loop?
            System.out.println(menuItemNumber + ". " + menuItem);
            menuItemNumber++;
        }
        System.out.println();
    }

    public boolean isQuit(int input) {
        return input == menuList.size();
    }
}

package com.twu.biblioteca;

import java.util.List;

public class Menu {

    private List<String> menuList;

    public Menu(List<String> menuList) {
        this.menuList = menuList;
    }

    public void display() {
        int menuItemNumber = 1;
        for (String menuItem : menuList) {
            System.out.println(menuItemNumber + ". " + menuItem);
            menuItemNumber++;
        }
    }


}

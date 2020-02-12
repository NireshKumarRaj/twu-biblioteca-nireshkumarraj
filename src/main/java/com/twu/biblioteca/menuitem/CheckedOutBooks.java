package com.twu.biblioteca.menuitem;

public class CheckedOutBooks implements MenuItem {

    private final String name;

    public CheckedOutBooks() {
        this.name = "List checked out books";
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}

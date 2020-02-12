package com.twu.biblioteca.menuitem;

public class MovieCheckOut implements MenuItem {

    private final String name;

    public MovieCheckOut() {
        name = "Checkout movie";
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}

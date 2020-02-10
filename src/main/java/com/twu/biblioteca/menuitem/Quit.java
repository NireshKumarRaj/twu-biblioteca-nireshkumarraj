package com.twu.biblioteca.menuitem;

public class Quit implements MenuItem{

    private final String name;

    public Quit() {
        name = "Quit";
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}

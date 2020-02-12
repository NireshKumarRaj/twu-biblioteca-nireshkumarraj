package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;

public class Quit implements MenuItem{

    private final String name;

    public Quit() {
        name = "Quit";
    }

    @Override
    public void execute() {
        InputReceiver.getInputReceiver().reset();
    }

    @Override
    public String getName() {
        return name;
    }
}

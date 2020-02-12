package com.twu.biblioteca.menuitem;

public class LoginMenuItem implements MenuItem {

    private final String name;

    public LoginMenuItem() {
        name = "Login";
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}

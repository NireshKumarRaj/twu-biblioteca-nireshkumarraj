package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.Authenticator;

public class LoginMenuItem implements MenuItem {

    private final String name;
    private Authenticator authenticator;

    public LoginMenuItem(Authenticator authenticator) {
        this.authenticator = authenticator;
        name = "Login";
    }

    @Override
    public void execute() {
        authenticator.authenticate("123-4567", "test1");
    }

    @Override
    public String getName() {
        return name;
    }
}

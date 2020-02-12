package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.model.Authenticator;

public class LoginMenuItem implements MenuItem {

    private final String name;
    private Authenticator authenticator;

    public LoginMenuItem(Authenticator authenticator) {
        this.authenticator = authenticator;
        name = "Login";
    }

    @Override
    public void execute() {
        authenticator.notifyListener("Enter Library Number:");
        String userName = InputReceiver.getInputReceiver().readLine();
        authenticator.notifyListener("Enter password: ");
        String password = InputReceiver.getInputReceiver().readLine();
        authenticator.authenticate(userName, password);
    }

    @Override
    public String getName() {
        return name;
    }
}

package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Authenticator;
import com.twu.biblioteca.view.InputReceiver;

public class LoginMenuItem implements MenuItem {

    private final String name;
    private Authenticator authenticator;

    public LoginMenuItem(Authenticator authenticator) {
        this.authenticator = authenticator;
        name = "Login";
    }

    @Override
    public void execute() {
        authenticator.notifyListener("Enter username:");
        String userName = InputReceiver.getInputReceiver().readLine();
        authenticator.notifyListener("Enter password: ");
        String password = InputReceiver.getInputReceiver().readLine();
        authenticator.authenticate(userName, password);
        authenticator.notifyListener("Your login is successful");
    }

    @Override
    public String getName() {
        return name;
    }
}
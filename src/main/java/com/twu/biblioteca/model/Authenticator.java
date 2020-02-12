package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.List;
import java.util.Optional;

public class Authenticator implements Model {

    private List<User> users;
    private View view;

    public Authenticator(List<User> users) {
        this.users = users;
    }

    public void authenticate(String libraryNumber, String password) {
        Optional<User> authUser = users.stream().filter(user -> user.is(libraryNumber, password)).findFirst();
        if (authUser.isPresent()) {
            view.setLoggedIn(true);
            view.setLoggedInUser(authUser.get());
            notifyListener("Your login is successful");
            return;
        }
        notifyListener("Sorry! Invalid credentials.");
    }

    @Override
    public void setListener(View view) {
        users.forEach(user -> user.setListener(view));
        this.view = view;
    }

    public void notifyListener(String message) {
        this.view.display(message);
    }
}

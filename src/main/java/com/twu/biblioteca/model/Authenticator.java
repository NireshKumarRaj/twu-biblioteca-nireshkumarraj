package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.List;

public class Authenticator implements Model {

    private List<User> users;
    private View view;

    public Authenticator() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        User user2 = new User("name", "email", "+919941980802", "123-4568", "test1");
        User user3 = new User("name", "email", "+919941980802", "123-4569", "test1");
        users = List.of(user1, user2, user3);
    }

    public boolean authenticate(String libraryNumber, String password) {
        return users.stream().anyMatch(user -> user.is(libraryNumber, password));
    }

    @Override
    public void setListener(View view) {
        users.forEach(user -> user.setListener(view));
        this.view = view;
    }

    public void notifyListener(String message) {
        this.view.display(message);
    }

    public void setUserLogin(boolean isLoggedIn) {
        view.setLoggedIn(isLoggedIn);
    }

    public void setLoggedInUser(String userName) {
        view.setLoggedInUser(userName);
    }
}

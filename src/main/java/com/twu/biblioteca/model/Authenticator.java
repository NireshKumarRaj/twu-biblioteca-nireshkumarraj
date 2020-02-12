package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.Map;

public class Authenticator implements Model {

    private Map<String, String> userCredentials;
    private View view;

    public Authenticator() {
        userCredentials = Map.of("123-4567", "test1", "234-5678", "test2");
    }

    public boolean authenticate(String username, String password) {
        System.out.println(userCredentials);
        return password.equals(userCredentials.get(username));
    }

    @Override
    public void setListener(View view) {
        this.view = view;
    }

    public void notifyListener(String message) {
        this.view.display(message);
    }
}

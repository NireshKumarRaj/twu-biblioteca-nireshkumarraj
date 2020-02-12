package com.twu.biblioteca;

import java.util.Map;

public class Authenticator {

    private Map<String, String> userCredentials;

    public Authenticator() {
        userCredentials = Map.of("123-4567", "test1", "234-5678", "test2");
    }

    public boolean authenticate(String username, String password) {
        System.out.println(userCredentials);
        return password.equals(userCredentials.get(username));
    }
}

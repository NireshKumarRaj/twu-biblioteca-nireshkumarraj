package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

public class User implements Model {

    private final String name;
    private final String email;
    private final String mobileNumber;
    private final String libraryNumber;
    private final String password;
    private View view;

    public User(String name, String email, String mobileNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }


    public void getDetails() {
        String details = String.format("Name : %s\nEmail : %s\nMobile : %s", name, email, mobileNumber);
        view.display(details);
    }

    @Override
    public void setListener(View view) {
        this.view = view;
    }
}

package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.Objects;

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
        notifyListener(details);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobileNumber, user.mobileNumber) &&
                Objects.equals(libraryNumber, user.libraryNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(view, user.view);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, mobileNumber, libraryNumber, password, view);
    }

    @Override
    public void setListener(View view) {
        this.view = view;
    }

    @Override
    public void notifyListener(String message) {
        view.display(message);
    }

    public boolean is(String libraryNumber, String password) {
        return this.libraryNumber.equals(libraryNumber) && this.password.equals(password);
    }
}

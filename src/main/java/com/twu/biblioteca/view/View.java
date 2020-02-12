package com.twu.biblioteca.view;

import java.util.List;

public interface View {
    void display(String message);

    void display(List<String> message);

    boolean isLoggedIn();

    void setLoggedIn(boolean isLoggedIn);
}

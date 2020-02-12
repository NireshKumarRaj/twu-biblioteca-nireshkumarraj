package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Model;

import java.io.PrintStream;
import java.util.List;

public class UI implements View {

    private final PrintStream outputWriter;
    private String loggedInUser;
    private boolean isLoggedIn;

    public UI(PrintStream outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void addModel(Model model) {
        model.setListener(this);
    }

    @Override
    public void display(String message) {
        outputWriter.println(message);
    }

    @Override
    public void display(List<String> toDisplayList) {
        for (int itemNumber = 1; itemNumber <= toDisplayList.size(); itemNumber++) {
            final String SEPARATOR = ". ";
            outputWriter.println((itemNumber) + SEPARATOR + toDisplayList.get(itemNumber - 1));
        }
        System.out.println();
    }

    @Override
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Override
    public String getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = true;
    }
}

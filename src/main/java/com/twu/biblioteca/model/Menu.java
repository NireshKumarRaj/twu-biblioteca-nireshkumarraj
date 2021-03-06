package com.twu.biblioteca.model;

import com.twu.biblioteca.menuitem.Auth;
import com.twu.biblioteca.menuitem.MenuItem;
import com.twu.biblioteca.view.View;

import java.util.List;
import java.util.stream.Collectors;

public class Menu implements Model {

    private List<MenuItem> menuOptions;
    private View view;

    public Menu(List<MenuItem> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void displayMenuOptions() {
        this.view.display("---- Menu -----");
        this.view.display(menuOptions.stream()
                .filter(menuItem -> view.isLoggedIn() || !(menuItem instanceof Auth))
                .map(MenuItem::getName)
                .collect(Collectors.toList()));
    }

    public boolean isQuit(int input) {
        if (view.isLoggedIn()) {
            return input == menuOptions.size();
        }
        List<MenuItem> unAuthMenuItems = menuOptions
                .stream()
                .filter(menuItem -> !(menuItem instanceof Auth))
                .collect(Collectors.toList());
        return input == unAuthMenuItems.size();
    }

    public void execute(int inputFromUser) {
        final String INVALID_OPTION_MESSAGE = "Please select a valid option!";
        if (inputFromUser > menuOptions.size()) {
            notifyListener(INVALID_OPTION_MESSAGE);
            return;
        }
        if (view.isLoggedIn())
            menuOptions.get(inputFromUser - 1).execute();
        else {
            List<MenuItem> unAuthMenuItems = menuOptions.stream().filter(menuItem -> !(menuItem instanceof Auth)).collect(Collectors.toList());
            unAuthMenuItems.get(inputFromUser - 1).execute();
        }
    }

    public void setListener(View view) {
        this.view = view;
    }

    @Override
    public void notifyListener(String message) {
        view.display(message);
    }
}

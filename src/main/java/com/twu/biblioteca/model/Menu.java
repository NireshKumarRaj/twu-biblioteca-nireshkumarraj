package com.twu.biblioteca.model;

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
                .map(MenuItem::getName)
                .collect(Collectors.toList()));
    }

    public boolean isQuit(int input) {
        return input == menuOptions.size();
    }

    public void execute(int inputFromUser) {
        final String INVALID_OPTION_MESSAGE = "Please select a valid option!";
        if (inputFromUser > menuOptions.size()) {
            view.display(INVALID_OPTION_MESSAGE);
            return;
        }
        menuOptions.get(inputFromUser - 1).execute();
    }

    public void setListener(View view) {
        this.view = view;
    }
}

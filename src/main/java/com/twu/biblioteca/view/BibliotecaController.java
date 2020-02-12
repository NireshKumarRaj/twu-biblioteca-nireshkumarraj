package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Menu;

public class BibliotecaController {

    private Menu menu;
    private UI ui;
    private boolean isQuit;

    public BibliotecaController(Menu menu, UI ui) {
        this.menu = menu;
        this.ui = ui;
    }

    private int getMenuOption() {
        ui.display("Enter input: ");
        return Integer.parseInt(InputReceiver.getInputReceiver().readLine());
    }

    private void readUserInput() {
        int inputFromUser = getMenuOption();
        menu.execute(inputFromUser);
        isQuit = menu.isQuit(inputFromUser);
    }

    public void start() {
        displayWelcomeMessage();
        do {
            menu.displayMenuOptions();
            readUserInput();
        } while (!isQuit);
    }

    void displayWelcomeMessage() {
        String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        ui.display(WELCOME_MESSAGE);
    }
}

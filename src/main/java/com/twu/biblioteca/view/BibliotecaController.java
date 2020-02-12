package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Authenticator;
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

    void readUserInput() {
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

    public void login() {
        ui.display("Please Login to continue:");
        ui.display("Enter username: ");
        String userName = InputReceiver.getInputReceiver().readLine();
        ui.display("Enter password: ");
        String password = InputReceiver.getInputReceiver().readLine();
        new Authenticator().authenticate(userName, password);
    }

    void displayWelcomeMessage() {
        String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        ui.display(WELCOME_MESSAGE);
    }
}

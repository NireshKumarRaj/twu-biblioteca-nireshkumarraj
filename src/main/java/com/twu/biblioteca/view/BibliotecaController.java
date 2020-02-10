package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Menu;

public class BibliotecaController {

    private Menu menu;
    private boolean isQuit;

    public BibliotecaController(Menu menu) {
        this.menu = menu;
    }

    private int getMenuOption() {
        System.out.println("Enter input: ");
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
            menu.display();
            readUserInput();
        } while (!isQuit);
    }

    void displayWelcomeMessage() {
        String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        System.out.println(WELCOME_MESSAGE);
    }
}

package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

public class BibliotecaController {

    private Library library;
    private Menu menu;
    private boolean isQuit = false;

    public BibliotecaController(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    private int getMenuOption() {
        System.out.println("Enter input: ");
        return Integer.parseInt(InputReceiver.getInputReceiver().readLine());
    }

    public void read() {
        int inputFromUser = getMenuOption();
        if (menu.isQuit(inputFromUser)) {
            this.isQuit = true;
        }
        menu.execute(inputFromUser);
    }

    public boolean isQuit() {
        return isQuit;
    }

    public void start() {
        do {
            menu.display();
            read();
        } while (!isQuit());
    }
}

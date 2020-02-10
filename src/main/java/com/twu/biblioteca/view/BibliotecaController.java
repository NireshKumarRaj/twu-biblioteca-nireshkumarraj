package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Menu;

public class BibliotecaController {

    private Menu menu;

    public BibliotecaController(Menu menu) {
        this.menu = menu;
    }

    private int getMenuOption() {
        System.out.println("Enter input: ");
        return Integer.parseInt(InputReceiver.getInputReceiver().readLine());
    }

    public boolean read() {
        int inputFromUser = getMenuOption();
        menu.execute(inputFromUser);
        return menu.isQuit(inputFromUser);
    }

    public void start() {
        do {
            menu.display();
        } while (!read());
    }
}

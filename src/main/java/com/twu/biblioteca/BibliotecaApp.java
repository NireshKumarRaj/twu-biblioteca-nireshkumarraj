package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.data.DummyDataGenerator;
import com.twu.biblioteca.model.Authenticator;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.MovieLibrary;
import com.twu.biblioteca.view.UI;

public class BibliotecaApp {

    private Library library;
    private Menu menu;
    private MovieLibrary movieLibrary;
    private Authenticator authenticator;

    public BibliotecaApp(Library library, Menu menu, MovieLibrary movieLibrary, Authenticator authenticator) {
        this.library = library;
        this.menu = menu;
        this.movieLibrary = movieLibrary;
        this.authenticator = authenticator;
    }

    public static void main(String[] args) {
        DummyDataGenerator dummyDataGenerator = new DummyDataGenerator();
        new BibliotecaApp(
                dummyDataGenerator.getLibrary(),
                dummyDataGenerator.getMenu(),
                dummyDataGenerator.getMovieLibrary(),
                dummyDataGenerator.getAuthenticator()
        ).start();
    }

    public void start() {
        UI ui = new UI(System.out);
        ui.addModel(menu);
        ui.addModel(library);
        ui.addModel(movieLibrary);
        ui.addModel(authenticator);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);
        bibliotecaController.start();
    }
}

package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.data.DummyDataGenerator;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.Model;
import com.twu.biblioteca.view.UI;

import java.util.List;

public class BibliotecaApp {

    private List<Model> models;
    private Menu menu;

    public BibliotecaApp(Menu menu, List<Model> models) {
        this.models = models;
        this.menu = menu;
    }

    public static void main(String[] args) {
        DummyDataGenerator dummyDataGenerator = new DummyDataGenerator();
        new BibliotecaApp(
                dummyDataGenerator.getMenu(),
                List.of(dummyDataGenerator.getLibrary(),
                        dummyDataGenerator.getMovieLibrary(),
                        dummyDataGenerator.getAuthenticator())
        ).start();
    }

    public void start() {
        UI ui = new UI(System.out);
        ui.addModel(menu);
        models.forEach(ui::addModel);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);
        bibliotecaController.start();
    }
}

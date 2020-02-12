package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.model.MovieLibrary;

public class MovieCheckOut implements MenuItem, Auth {

    private final String name;
    private MovieLibrary movieLibrary;

    public MovieCheckOut(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
        name = "Checkout movie";
    }

    @Override
    public void execute() {
        movieLibrary.notifyListener("Enter movie name: ");
        String movieName = InputReceiver.getInputReceiver().readLine();
        movieLibrary.checkout(movieName);
    }

    @Override
    public String getName() {
        return name;
    }
}

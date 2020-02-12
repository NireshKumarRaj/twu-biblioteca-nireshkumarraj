package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;

public class MovieCheckOut implements MenuItem {

    private final String name;
    private MovieLibrary movieLibrary;

    public MovieCheckOut(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
        name = "Checkout movie";
    }

    @Override
    public void execute() {
        movieLibrary.checkout("The Social Network");
    }

    @Override
    public String getName() {
        return name;
    }
}

package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;

public class MovieList implements MenuItem {

    private MovieLibrary movieLibrary;
    private final String name;

    public MovieList(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
        name = "List Movies";
    }

    @Override
    public void execute() {
        movieLibrary.listAvailableMovies();
    }

    @Override
    public String getName() {
        return this.name;
    }
}

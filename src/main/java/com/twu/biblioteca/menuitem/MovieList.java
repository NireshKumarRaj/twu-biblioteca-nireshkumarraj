package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.MovieLibrary;

public class MovieList implements MenuItem {

    private MovieLibrary movieLibrary;

    public MovieList(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void execute() {
        movieLibrary.listAvailableMovies();
    }

    @Override
    public String getName() {
        return null;
    }
}

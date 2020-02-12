package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieLibrary implements Model {

    private List<Movie> movies;
    private List<Movie> checkedOutMovies;
    private View view;

    public MovieLibrary(List<Movie> movies) {
        this.movies = movies;
        checkedOutMovies = new ArrayList<>();
    }


    public void listAvailableMovies() {
        view.display(movies.stream().map(Movie::displayDetails).collect(Collectors.toList()));
    }

    public void setListener(View view) {
        this.view = view;
    }

    public void checkout(String movieName) {
        Optional<Movie> movie = movies.stream()
                .filter(movieItem -> movieItem.is(movieName))
                .filter(movieItem -> !checkedOutMovies.contains(movieItem))
                .findFirst();
        if (movie.isPresent()) {
            checkedOutMovies.add(movie.get());
            view.display("Thank you! Enjoy the movie");
        } else {
            view.display("Sorry, that movie is not available");
        }
    }
}

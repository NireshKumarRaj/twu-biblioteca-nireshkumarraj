package com.twu.biblioteca.model;

import com.twu.biblioteca.view.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieLibrary implements Model {

    private List<Movie> movies;
    private List<Movie> checkedOutMovies;
    private Customer customer;

    public MovieLibrary(List<Movie> movies) {
        this.movies = movies;
        checkedOutMovies = new ArrayList<>();
    }


    public void listAvailableMovies() {
        customer.display(movies.stream().map(Movie::displayDetails).collect(Collectors.toList()));
    }

    public void setListener(Customer customer) {
        this.customer = customer;
    }

    public void checkout(String movieName) {
        Optional<Movie> movie = movies.stream().filter(movieItem -> movieItem.is(movieName)).findFirst();
        if (movie.isPresent()) {
            checkedOutMovies.add(movie.get());
            customer.display("Thank you! Enjoy the movie");
        }
    }
}

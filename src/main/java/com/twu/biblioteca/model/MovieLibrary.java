package com.twu.biblioteca.model;

import com.twu.biblioteca.view.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class MovieLibrary {

    private List<Movie> movies;
    private Customer customer;

    public MovieLibrary(List<Movie> movies) {
        this.movies = movies;
    }


    public void listAvailableMovies() {
        customer.display(movies.stream().map(Movie::displayDetails).collect(Collectors.toList()));
    }

    public void setListener(Customer customer) {
        this.customer = customer;
    }
}

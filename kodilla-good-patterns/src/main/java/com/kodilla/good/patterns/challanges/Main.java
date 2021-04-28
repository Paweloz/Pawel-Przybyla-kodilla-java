package com.kodilla.good.patterns.challanges;


import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final MovieStore movieStore = new MovieStore();
        String moviesTitles = movieStore.getMovies().entrySet().stream()
                .flatMap(movie ->movie.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(moviesTitles);
    }
}

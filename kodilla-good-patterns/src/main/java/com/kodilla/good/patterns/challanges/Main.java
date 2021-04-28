package com.kodilla.good.patterns.challanges;


import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> movieList = convertMapToList();
        displayMovieTitles(movieList);
    }

    private static void displayMovieTitles(List<String> movieList) {
        for(String movieTitle : movieList) {
            movieTitle = removeLastCharFromLastString(movieList, movieTitle);
            System.out.print(movieTitle);
        }
    }

    private static List<String> convertMapToList() {
        final MovieStore movieStore = new MovieStore();
        return   movieStore.getMovies().entrySet().stream()
                .flatMap(movie ->movie.getValue().stream())
                .limit(movieStore.getMovies().values().size()+3)
                .map(movie -> movie+"!")
                .collect(Collectors.toList());

    }

    private static String removeLastCharFromLastString(List<String> movieList, String movieTitle) {
        if (movieTitle.equals(movieList.get(movieList.size() - 1))) {
            movieTitle = movieTitle.substring(0, movieTitle.length() - 1);
        }
        return movieTitle;
    }
}

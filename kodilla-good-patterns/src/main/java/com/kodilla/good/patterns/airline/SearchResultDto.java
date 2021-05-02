package com.kodilla.good.patterns.airline;

import java.util.List;

public class SearchResultDto {
    private final List<Route> trips;
    private final boolean noResults;

    public SearchResultDto(List<Route> trips, boolean isFound) {
        this.trips = trips;
        this.noResults = isFound;
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        for(Route route : trips){
            result.append(route).append("\n");
        }
        return result + "Found trips : " + !noResults;
    }
}

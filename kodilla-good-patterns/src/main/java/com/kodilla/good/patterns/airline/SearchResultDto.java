package com.kodilla.good.patterns.airline;

import java.util.List;

public class SearchResultDto {
    private final List<Route> trips;
    private final boolean isEmpty;

    public SearchResultDto(List<Route> trips, boolean isEmpty) {
        this.trips = trips;
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        if(isEmpty){
            result.append("Sorry, no flights has been found\n");
        }else {
            for (Route route : trips) {
                result.append(route).append("\n");
            }
        }
        return result + "Found flights : " + !isEmpty;
    }
}

package com.kodilla.good.patterns.airline;

public class Application {
    public static void main(String[] args) {
        RoutesDataBase flightDataBase = new RoutesDataBase();
        CustomerDataBase customerDataBase = new CustomerDataBase();
        Search search = new Search(flightDataBase);
        FlightRequestCollector flightRequestCollector = new FlightRequestCollector(flightDataBase,customerDataBase);
        FlightRequest flightRequest = flightRequestCollector.collect();

        SearchResultDto resultsFrom = search.searchFlightsFrom(flightRequest);
        System.out.println(resultsFrom);

        SearchResultDto resultsTo = search.searchFlightsTo(flightRequest);
        System.out.println(resultsTo);

        String viaAirport = flightRequestCollector.generateStop(flightRequest);
        SearchResultDto resultsVia = search.searchFlightsVia(flightRequest, viaAirport);
        System.out.println(resultsVia);
    }
}
package com.kodilla.good.patterns.airline;

public class Application {
    public static void main(String[] args) {
        RoutesDataBase flightDataBase = new RoutesDataBase();
        CustomerDataBase customerDataBase = new CustomerDataBase();
        Search search = new Search(flightDataBase);
        FlightRequestCollector flightRequestCollector = new FlightRequestCollector(flightDataBase,customerDataBase);
        FlightRequest flightRequest = flightRequestCollector.collect();

        search.searchFlightsFrom(flightRequest);
        search.searchFlightsTo(flightRequest);
        search.searchFlightsVia(flightRequest);
    }
}

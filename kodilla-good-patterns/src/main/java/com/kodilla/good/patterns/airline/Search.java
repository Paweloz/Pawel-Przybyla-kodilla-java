package com.kodilla.good.patterns.airline;

public class Search {

    private final RoutesDataBase flightDataBase;

    public Search(RoutesDataBase flightDataBase) {
        this.flightDataBase = flightDataBase;
    }

    public void searchFlightsFrom(FlightRequest flightRequest) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avaliable flights from " + flightRequest.getRoute().getDepartureAirport());

        flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(flightRequest.getRoute().getDepartureAirport()))
                .forEach(System.out::println);
    }

    public void searchFlightsTo(FlightRequest flightRequest) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avaliable flights to " + flightRequest.getRoute().getArrivalAriport());

        flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getArrivalAriport().equals(flightRequest.getRoute().getArrivalAriport()))
                .forEach(System.out::println);
    }

    public void searchFlightsVia(FlightRequest flightRequest) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avalible flights from " +
                flightRequest.getRoute().getDepartureAirport() + " to " +
                flightRequest.getRoute().getArrivalAriport() + " via "+ flightRequest.getViaAirport());

        flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(flightRequest.getRoute().getDepartureAirport()))
                .filter(port -> port.getArrivalAriport().equals(flightRequest.getViaAirport()))
                .forEach(System.out::println);
        flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(flightRequest.getViaAirport()))
                .filter(port -> port.getArrivalAriport().equals(flightRequest.getRoute().getArrivalAriport()))
                .forEach(System.out::println);
    }
}

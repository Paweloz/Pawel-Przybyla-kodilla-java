package com.kodilla.good.patterns.airline;

import java.util.List;
import java.util.stream.Collectors;

public class Search {

    private final RoutesDataBase flightDataBase;

    public Search(RoutesDataBase flightDataBase) {
        this.flightDataBase = flightDataBase;
    }

    public SearchResultDto searchFlightsFrom(FlightRequest flightRequest) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avaliable flights from " + flightRequest.getRoute().getDepartureAirport());

        List<Route> result = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(flightRequest.getRoute().getDepartureAirport()))
                .collect(Collectors.toList());
        return new SearchResultDto(result, result.isEmpty());
    }

    public SearchResultDto searchFlightsTo(FlightRequest flightRequest) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avaliable flights to " + flightRequest.getRoute().getArrivalAriport());

        List<Route> result = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getArrivalAriport().equals(flightRequest.getRoute().getArrivalAriport()))
                .collect(Collectors.toList());
        return new SearchResultDto(result, result.isEmpty());
    }

    public SearchResultDto searchFlightsVia(FlightRequest flightRequest, String viaAirport) {
        System.out.println("\nRequest from customer : " + flightRequest.getCustomer() +
                "\nAll avalible flights from " +
                flightRequest.getRoute().getDepartureAirport() + " to " +
                flightRequest.getRoute().getArrivalAriport() + " via "+ viaAirport);

        List<Route> resultFirstTrip = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(flightRequest.getRoute().getDepartureAirport()))
                .filter(port -> port.getArrivalAriport().equals(viaAirport))
                .collect(Collectors.toList());
        List<Route> resultSecondTrip = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(viaAirport))
                .filter(port -> port.getArrivalAriport().equals(flightRequest.getRoute().getArrivalAriport()))
                .collect(Collectors.toList());
        resultFirstTrip.addAll(resultSecondTrip);
        return new SearchResultDto(resultFirstTrip, resultFirstTrip.isEmpty());
    }
}

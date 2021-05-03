package com.kodilla.good.patterns.airline;

import java.util.List;
import java.util.stream.Collectors;

public class Search {

    private final RoutesDataBase flightDataBase;

    public Search(RoutesDataBase flightDataBase) {
        this.flightDataBase = flightDataBase;
    }

    public SearchResultDto searchFlightsFrom(Customer customer, String departureAirport) {
        System.out.println("\nRequest from customer : " + customer +
                "\nAll avaliable flights from " + departureAirport);

        List<Route> result = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toList());
        return new SearchResultDto(result, result.isEmpty());
    }

    public SearchResultDto searchFlightsTo(Customer customer, String arrivalAirport) {
        System.out.println("\nRequest from customer : " + customer +
                "\nAll avaliable flights to " + arrivalAirport);

        List<Route> result = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getArrivalAriport().equals(arrivalAirport))
                .collect(Collectors.toList());
        return new SearchResultDto(result, result.isEmpty());
    }

    public SearchResultDto searchFlightsVia(Customer customer, String departureAirport, String arrivalAirport,
                                            String viaAirport) {
        System.out.println("\nRequest from customer : " + customer +
                "\nAll avalible flights from " +
                departureAirport + " to " +
                arrivalAirport + " via "+ viaAirport);

        List<Route> resultFirstTrip = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(departureAirport))
                .filter(port -> port.getArrivalAriport().equals(viaAirport))
                .collect(Collectors.toList());
        List<Route> resultSecondTrip = flightDataBase.getRoutesDataBase().stream()
                .filter(port -> port.getDepartureAirport().equals(viaAirport))
                .filter(port -> port.getArrivalAriport().equals(arrivalAirport))
                .collect(Collectors.toList());
        resultFirstTrip.addAll(resultSecondTrip);
        return new SearchResultDto(resultFirstTrip, resultFirstTrip.isEmpty());
    }
}

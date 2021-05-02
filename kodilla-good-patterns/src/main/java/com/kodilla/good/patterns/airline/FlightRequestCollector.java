package com.kodilla.good.patterns.airline;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FlightRequestCollector {
    private final RoutesDataBase flightDataBase;
    private final CustomerDataBase customerDataBase;

    public FlightRequestCollector(RoutesDataBase flightDataBase, CustomerDataBase customerDataBase) {
        this.flightDataBase = flightDataBase;
        this.customerDataBase = customerDataBase;
    }

    public FlightRequest collect(){
        Random generator = new Random();

        Route[] routes = flightDataBase.getRoutesDataBase().toArray(new Route[0]);
        List<String> posibleStops = flightDataBase.getRoutesDataBase().stream()
                .map(Route::getArrivalAriport)
                .collect(Collectors.toList());
        int customerNr = generator.nextInt(customerDataBase.getCustomersList().size());
        int routeNr = generator.nextInt(flightDataBase.getRoutesDataBase().size());
        int stopNr = generateStop(generator, routes, posibleStops, routeNr);


        return new FlightRequest(customerDataBase.getCustomersList().get(customerNr),
                routes[routeNr], posibleStops.get(stopNr));
    }

    private int generateStop(Random generator, Route[] routes, List<String> posibleStops, int routeNr) {
        int stopNr=0;
        boolean correctStop = false;
        while (!correctStop) {
            stopNr = generator.nextInt(posibleStops.size());
            if(!posibleStops.get(stopNr).equals(routes[routeNr].getArrivalAriport()) &&
                    !posibleStops.get(stopNr).equals(routes[routeNr].getDepartureAirport())) {
                correctStop = true;
            }
        }
        return stopNr;
    }
}

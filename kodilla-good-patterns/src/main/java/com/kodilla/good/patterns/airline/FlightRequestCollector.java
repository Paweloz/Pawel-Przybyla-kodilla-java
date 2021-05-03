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
        int customerNr = generator.nextInt(customerDataBase.getCustomersList().size());
        int routeNr = generator.nextInt(flightDataBase.getRoutesDataBase().size());

        return new FlightRequest(customerDataBase.getCustomersList().get(customerNr),
                routes[routeNr]);
    }

    public String generateStop(FlightRequest request) {
        Random generator = new Random();
        int stopNr=0;
        boolean correctStop = false;
        List<String> posibleStops = flightDataBase.getRoutesDataBase().stream()
                .map(Route::getArrivalAriport)
                .collect(Collectors.toList());
        while (!correctStop) {
            stopNr = generator.nextInt(posibleStops.size());
            if(!posibleStops.get(stopNr).equals(request.getRoute().getArrivalAriport()) &&
                    !posibleStops.get(stopNr).equals(request.getRoute().getDepartureAirport())) {
                correctStop = true;
            }
        }
        return posibleStops.get(stopNr);
    }
}

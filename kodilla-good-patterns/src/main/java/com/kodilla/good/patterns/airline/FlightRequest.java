package com.kodilla.good.patterns.airline;

public class FlightRequest {
    private final Customer customer;
    private final Route route;
    private final String viaAirport;

    public FlightRequest(Customer customer, Route route, String viaAirport) {
        this.customer = customer;
        this.route = route;
        this.viaAirport = viaAirport;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                 customer +
                 route +
                '}';
    }

    public String getViaAirport() {
        return viaAirport;
    }
}

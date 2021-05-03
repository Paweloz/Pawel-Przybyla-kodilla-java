package com.kodilla.good.patterns.airline;

public class FlightRequest {
    private final Customer customer;
    private final Route route;

    public FlightRequest(Customer customer, Route route) {
        this.customer = customer;
        this.route = route;
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
}

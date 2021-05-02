package com.kodilla.good.patterns.airline;

import java.util.Objects;

public class Route {
    private final String arrivalAriport;
    private final String departureAirport;

    public Route(String arrivalAriport, String departureAirport) {
        this.arrivalAriport = arrivalAriport;
        this.departureAirport = departureAirport;
    }

    public String getArrivalAriport() {
        return arrivalAriport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return arrivalAriport.equals(route.arrivalAriport) && departureAirport.equals(route.departureAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivalAriport, departureAirport);
    }

    @Override
    public String toString() {
        return "Route{" +
                "departureAirport='" + departureAirport + '\'' +
                "arrivalAriport='" + arrivalAriport + '\'' +
                '}';
    }
}

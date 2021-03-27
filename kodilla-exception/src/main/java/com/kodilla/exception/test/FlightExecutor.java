package com.kodilla.exception.test;

import java.util.Optional;

public class FlightExecutor {

    public static void main(String[] args) {
        FlightBrowser flightBrowser = new FlightBrowser();
        Flight flight = null;//new Flight("Hamburg", "Sosnowiec");

        //Sprawdzenie czy obiekt Flight został poprawnie zainicjowany
        Optional<Flight> optionalFlight = Optional.ofNullable(flight);
        flight = optionalFlight.orElse(new Flight("",""));
        try{
            flightBrowser.findFlight(flight);
        }catch(RouteNotFoundException e){
            System.out.println(e);
        }
    }
}

package com.kodilla.exception.test;

public class FlightExecutor {

    public static void main(String[] args) {
        FlightBrowser flightBrowser = new FlightBrowser();
        Flight flight = new Flight("Hamburg", "Sosnowiec");

        try{
            flightBrowser.findFlight(flight);
        }catch(RouteNotFoundException e){
            System.out.println(e);
        }
    }
}

package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FlightBrowser {
    private String arrivalAirport;
    private String departureAirport;
    private boolean canFlyArrival;
    private boolean canFlyDeparture;

    public void findFlight(Flight flight) throws  RouteNotFoundException{
        //Zainicjowana mapa lotnisk
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Berlin",true);
        airports.put("Radom",false);
        airports.put("Praga",true);
        airports.put("Warsaw",true);
        airports.put("Paris",false);
        airports.put("London",false);
        airports.put("Madrid",true);
        airports.put("Hamburg",false);
        airports.put("New York",false);
        airports.put("Moscow",true);
        airports.put("Budapest",false);

        //Szuka obu lotnisk i przypisuje je do zmiennych
        for(Map.Entry<String, Boolean> entry : airports.entrySet()){
            if(entry.getKey().equals(flight.getDepartureAirport())){
                departureAirport = entry.getKey();
                canFlyDeparture = entry.getValue();
            }else if(entry.getKey().equals(flight.getArrivalAirport())){
                arrivalAirport = entry.getKey();
                canFlyArrival = entry.getValue();
            }
        }

        //Upewnia, że zmienie zostały zainicjowane, jak nie to przypisuje im pustą wartość
        Optional<String> optionalArrival = Optional.ofNullable(arrivalAirport);
        Optional<String> optionalDeparture = Optional.ofNullable(departureAirport);
        departureAirport = optionalDeparture.orElse("");
        arrivalAirport = optionalArrival.orElse("");

        //Sprawdza czy zmienne zostały zainicowane właściwym lotniskiem czy "" z Optional
        //Prościej by chyba było z !=null, ale chciałem wytestować Optional
        if(departureAirport.equals(flight.getDepartureAirport())){
            if(canFlyDeparture) {
                System.out.println("Airport " + flight.getDepartureAirport() + " exist and is avaliable");
            }else {
                System.out.println("Airport " + flight.getDepartureAirport() + " exist, but is out of order");
            }
        }else {
            throw new RouteNotFoundException("Airport "+flight.getDepartureAirport()+" doesn't exist");
        }

        if(arrivalAirport.equals(flight.getArrivalAirport())){
            if(canFlyArrival) {
                System.out.println("Airport " + flight.getArrivalAirport() + " exist and is avaliable");
            }else {
                System.out.println("Airport " + flight.getArrivalAirport() + " exist, but is out of order");
            }
        }else {
            throw new RouteNotFoundException("Airport "+flight.getArrivalAirport()+" doesn't exist");
        }
    }
}

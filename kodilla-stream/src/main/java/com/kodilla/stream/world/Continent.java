package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    final List<Country> countries = new ArrayList<>();

    public void addCountry(Country country){
        countries.add(country);
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "countries=" + countries +
                '}';
    }
}

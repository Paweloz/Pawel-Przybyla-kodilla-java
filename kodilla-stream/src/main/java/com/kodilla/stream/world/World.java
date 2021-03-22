package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class World {
    final List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent){
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum, current) -> sum=sum.add(current));

    }


    @Override
    public String toString() {
        return "World{" +
                "continents=" + continents +
                '}';
    }
}

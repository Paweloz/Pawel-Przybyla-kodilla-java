package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    static Continent europe = new Continent();
    static Continent asia = new Continent();
    static Continent africa = new Continent();
    static Continent northAmerica = new Continent();


    @BeforeAll
    static void setContinent(){
        europe.addCountry(new Country("Poland", new BigDecimal("36750568")));
        europe.addCountry(new Country("German", new BigDecimal("65321958")));
        europe.addCountry(new Country("France", new BigDecimal("96234589")));
        europe.addCountry(new Country("Austria", new BigDecimal("35698745")));
        asia.addCountry(new Country("China",new BigDecimal("3785632159")));
        asia.addCountry(new Country("Indie",new BigDecimal("2563215987")));
        asia.addCountry(new Country("South Korea", new BigDecimal("695324789")));
        asia.addCountry(new Country("North Korea", new BigDecimal("362589658")));
        africa.addCountry(new Country("RPA", new BigDecimal("369852515")));
        africa.addCountry(new Country("Nigeria", new BigDecimal("69581324")));
        africa.addCountry(new Country("Uganda",new BigDecimal("3698521")));
        africa.addCountry(new Country("Egipt", new BigDecimal("89652147")));
        northAmerica.addCountry(new Country("Canda",new BigDecimal("125984789")));
        northAmerica.addCountry(new Country("USA",new BigDecimal("356957147")));
        northAmerica.addCountry(new Country("Mexico",new BigDecimal("56987156")));
        northAmerica.addCountry(new Country("Honduras",new BigDecimal("23541698")));
    }

    @Test //Test for getPeopleQuantity for class World
    void testGetPeopleQuantity(){
        //Given
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);

        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeople = new BigDecimal("8737023750");
        assertEquals(expectedPeople,peopleQuantity);
    }
}

package com.kodilla.good.patterns.airline;

import java.util.LinkedList;
import java.util.List;

public class CustomerDataBase {
    private final List<Customer> customersList = new LinkedList<>();

    public CustomerDataBase() {
        customersList.add(new Customer("Mariusz", "Kowalski", 758456258));
        customersList.add(new Customer("Adam","Nowak",896258743));
        customersList.add(new Customer("Joanna","Bąk",784625987));
        customersList.add(new Customer("Anna","Żużel",632547851));
        customersList.add(new Customer("Piotr","Robak",783214985));
        customersList.add(new Customer("Halina","Gruz",698257148));
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }
}

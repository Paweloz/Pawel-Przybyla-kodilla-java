package com.kodilla.good.patterns.airline;

public class Customer {
    private final String customerFirstName;
    private final String customerLastName;
    private final int customerPhoneNumber;

    public Customer(String customerFirstName, String customerLastName, int customerPhoneNumber) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @Override
    public String toString() {
        return  customerFirstName + " " + customerLastName + "\nPhone number " + customerPhoneNumber;
    }
}

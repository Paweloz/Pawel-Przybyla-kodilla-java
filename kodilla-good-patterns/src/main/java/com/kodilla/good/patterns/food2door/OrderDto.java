package com.kodilla.good.patterns.food2door;

public class OrderDto {
    private final  Customer customer;
    private final boolean successfullyPlaced;

    public OrderDto(Customer customer, boolean successfullyPlaced) {
        this.customer = customer;
        this.successfullyPlaced = successfullyPlaced;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "customer=" + customer +
                ", successfullyPlaced=" + successfullyPlaced +
                '}';
    }
}

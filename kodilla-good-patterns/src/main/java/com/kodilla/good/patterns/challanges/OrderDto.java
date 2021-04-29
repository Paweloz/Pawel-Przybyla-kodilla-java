package com.kodilla.good.patterns.challanges;

public class OrderDto {
    private Customer customer;
    private boolean isPlaced;

    public OrderDto(Customer customer, boolean isPlaced) {
        this.customer = customer;
        this.isPlaced = isPlaced;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "customer=" + customer +
                ", isPlaced=" + isPlaced +
                '}';
    }
}

package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class OrderRequest {
    private final int orderNumber;
    private final Customer customer;
    private final String manufacturerName;
    private final String productType;
    private final int quantity;
    private final LocalDateTime orderTime;

    public OrderRequest(int orderNumber, Customer customer, String manufacturerName, String productType, int quantity, LocalDateTime orderTime) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.manufacturerName = manufacturerName;
        this.productType = productType;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}

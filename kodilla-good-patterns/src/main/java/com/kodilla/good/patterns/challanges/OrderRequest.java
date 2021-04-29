package com.kodilla.good.patterns.challanges;

import java.time.LocalDateTime;

public class OrderRequest {
    private final Customer customer;
    private final Product product;
    private final int quantity;
    private final LocalDateTime orderTime;

    public OrderRequest(Customer customer, Product product, int quantity, LocalDateTime orderTime) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }

    public Customer getCustomer() {
        return customer;
    }
    public int getQuantity() {
        return quantity;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public Product getProduct() {
        return product;
    }
}

package com.kodilla.good.patterns.challanges;

public class Customer {
    private final String nickName;
    private final String deliveryAddress;

    public Customer(String nickName, String deliveryAddress) {
        this.nickName = nickName;
        this.deliveryAddress = deliveryAddress;
    }

    public String getNickName() {
        return nickName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}

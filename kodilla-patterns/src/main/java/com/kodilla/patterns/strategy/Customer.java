package com.kodilla.patterns.strategy;

public class Customer {
    private final String name;
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    public void setBuyPredictor(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }

    public String getName() {
        return name;
    }
}
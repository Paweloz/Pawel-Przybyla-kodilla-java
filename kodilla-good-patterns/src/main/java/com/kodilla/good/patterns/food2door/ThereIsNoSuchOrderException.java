package com.kodilla.good.patterns.food2door;

public class ThereIsNoSuchOrderException extends Exception{
    public ThereIsNoSuchOrderException(String message) {
        super(message);
    }
}

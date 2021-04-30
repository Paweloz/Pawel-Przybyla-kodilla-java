package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        GeneralProcessor generalProcessor = new GeneralProcessor();
        OrderRequestRetriver orderRequestRetriver = new OrderRequestRetriver();
        try {
            OrderRequest orderRequest = orderRequestRetriver.retrive(2);
            generalProcessor.processOrder(orderRequest);
        } catch (ThereIsNoSuchOrderException e) {
            System.out.println(e);
        }
    }
}

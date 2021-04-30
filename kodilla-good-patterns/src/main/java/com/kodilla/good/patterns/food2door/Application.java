package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        HealthyShop healthyShop = new HealthyShop(new MailService(),orderRepository, new OrderService());
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(new MailService(),orderRepository, new OrderService());
        ExtraFoodStore extraFoodStore = new ExtraFoodStore(new MailService(),orderRepository, new OrderService());
        SomeOtherManufacturer someOtherManufacturer = new SomeOtherManufacturer(new MailService(),
                orderRepository, new OrderService());
        OrderRequestRetriver orderRequestRetriver = new OrderRequestRetriver();
        GeneralProcessor generalProcessor = new GeneralProcessor( healthyShop,
                glutenFreeShop,extraFoodStore,someOtherManufacturer);

        try {
            OrderRequest orderRequest = orderRequestRetriver.retrive(3);
            generalProcessor.processOrder(orderRequest);
        } catch (ThereIsNoSuchOrderException e) {
            System.out.println(e);
        }
    }
}

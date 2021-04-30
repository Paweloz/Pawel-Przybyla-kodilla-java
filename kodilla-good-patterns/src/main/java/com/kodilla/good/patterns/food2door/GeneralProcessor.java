package com.kodilla.good.patterns.food2door;

public class GeneralProcessor {
    OrderRepository orderRepository = new OrderRepository();
    HealthyShop healthyShop = new HealthyShop(new MailService(),orderRepository, new OrderService());
    GlutenFreeShop glutenFreeShop = new GlutenFreeShop(new MailService(),orderRepository, new OrderService());
    ExtraFoodStore extraFoodStore = new ExtraFoodStore(new MailService(),orderRepository, new OrderService());
    SomeOtherManufacturer someOtherManufacturer = new SomeOtherManufacturer(new MailService(),
            orderRepository, new OrderService());

    public void processOrder( OrderRequest orderRequest ){
        switch (orderRequest.getManufacturerName()){
            case "HealthyShop" :
                healthyShop.process(orderRequest);
            case "GlutenFreeShop" :
                glutenFreeShop.process(orderRequest);
            case "ExtraFoodStore" :
                extraFoodStore.process(orderRequest);
            case "SomeOtherManufacturer" :
                someOtherManufacturer.process(orderRequest);
        }
    }
}

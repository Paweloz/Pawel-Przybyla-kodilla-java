package com.kodilla.good.patterns.food2door;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Map<String, List<OrderRequest>> generalDataBase = new HashMap<>();
        generalDataBase.put("HS", new LinkedList<>());
        generalDataBase.put("GFS", new LinkedList<>());
        generalDataBase.put("EFS", new LinkedList<>());
        generalDataBase.put("SOM", new LinkedList<>());
        OrderRepository orderRepository = new OrderRepository(generalDataBase);

        Set<Manufacturer> companies = new HashSet<>();
        companies.add(new HealthyShop(new MailService(),
                orderRepository, new OrderService()));
        companies.add(new GlutenFreeShop(new MailService(),
                        orderRepository, new OrderService()));
        companies.add(new ExtraFoodStore(new MailService(),
                orderRepository, new OrderService()));
        companies.add(new SomeOtherManufacturer(new MailService(),
                orderRepository, new OrderService()));

        OrderRequestRetriver orderRequestRetriver = new OrderRequestRetriver();
        GeneralProcessor generalProcessor = new GeneralProcessor(companies);
        try {
            OrderRequest orderRequest = orderRequestRetriver.retrive(3);
            generalProcessor.processOrder(orderRequest);
            orderRequest = orderRequestRetriver.retrive(2);
            generalProcessor.processOrder(orderRequest);
        } catch (ThereIsNoSuchOrderException e) {
            System.out.println(e);
        }
    }
}

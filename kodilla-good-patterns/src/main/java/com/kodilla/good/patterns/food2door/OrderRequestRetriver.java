package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class OrderRequestRetriver {
    List<OrderRequest> orders = new LinkedList<>();

    public OrderRequestRetriver() {
        orders.add(new OrderRequest(1, new Customer("Andrzej"),
                "HealthyShop", "Humus",5,
                LocalDateTime.of(2021,3,31,17,57)));
        orders.add(new OrderRequest(2, new Customer("Miro"),
                "ExtraFoodStore", "Pieprz",1,
                LocalDateTime.of(2021,4,29,16,2)));
        orders.add(new OrderRequest(3, new Customer("Kalina"),
                "ExtraFoodStore", "Zioła",3,
                LocalDateTime.of(2021,3,29,22,12)));
        orders.add(new OrderRequest(4, new Customer("Aśka"),
                "GlutenFreeShop", "Herbata",24,
                LocalDateTime.of(2021,3,21,2,36)));
        orders.add(new OrderRequest(5, new Customer("Piotrek"),
                "HealthyShop", "Kawa",4,
                LocalDateTime.of(2021,4,17,14,26)));
        orders.add(new OrderRequest(6, new Customer("Halina"),
                "SomeOtherManufacturer", "Dziurawiec",15,
                LocalDateTime.of(2021,4,7,4,6)));
    }
    public OrderRequest retrive(int orderNumber) throws ThereIsNoSuchOrderException {
        if(orderNumber >= orders.size()){
            throw new ThereIsNoSuchOrderException("There is no such order");
        }
        return orders.get(orderNumber);
    }
}

package com.kodilla.good.patterns.food2door;

import java.util.LinkedList;
import java.util.List;

public class OrderRepository {
    private final List<OrderRequest> healthyShop = new LinkedList<>();
    private final List<OrderRequest> extraFoodStore = new LinkedList<>();
    private final List<OrderRequest> glutenFreeShop = new LinkedList<>();
    private final List<OrderRequest> someOtherManufacturer = new LinkedList<>();

    public void createOrder( OrderRequest orderRequest ) {
        switch (orderRequest.getManufacturerName()){
            case "HealthyShop" :
                healthyShop.add(orderRequest);
                System.out.println("Order number "+orderRequest.getOrderNumber()+" has been added to HealthyShop database");
            case "GlutenFreeShop" :
                glutenFreeShop.add(orderRequest);
                System.out.println("Order number "+orderRequest.getOrderNumber()+" has been to GlutenFreeShop database");
            case "ExtraFoodStore" :
                extraFoodStore.add(orderRequest);
                System.out.println("Order number "+orderRequest.getOrderNumber()+" has been to ExtraFoodStore database");
            case "SomeOtherManufacturer" :
                someOtherManufacturer.add(orderRequest);
                System.out.println("Order number "+orderRequest.getOrderNumber()+" has been to SomeOtherManufacturer database");
        }
    }

    public List<OrderRequest> getHealthyShop() {
        return healthyShop;
    }

    public List<OrderRequest> getExtraFoodStore() {
        return extraFoodStore;
    }

    public List<OrderRequest> getGlutenFreeShop() {
        return glutenFreeShop;
    }

    public List<OrderRequest> getSomeOtherManufacturer() {
        return someOtherManufacturer;
    }
}

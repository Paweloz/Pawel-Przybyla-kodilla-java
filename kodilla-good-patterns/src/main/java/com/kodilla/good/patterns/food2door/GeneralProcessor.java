package com.kodilla.good.patterns.food2door;

public class GeneralProcessor {

    private final HealthyShop healthyShop;
    private final GlutenFreeShop glutenFreeShop;
    private final ExtraFoodStore extraFoodStore;
    private final SomeOtherManufacturer someOtherManufacturer;

    public GeneralProcessor( HealthyShop healthyShop,
                            GlutenFreeShop glutenFreeShop, ExtraFoodStore extraFoodStore,
                            SomeOtherManufacturer someOtherManufacturer) {
        this.healthyShop = healthyShop;
        this.glutenFreeShop = glutenFreeShop;
        this.extraFoodStore = extraFoodStore;
        this.someOtherManufacturer = someOtherManufacturer;
    }

    public void processOrder(OrderRequest orderRequest ) {
        switch (orderRequest.getManufacturerName()) {
            case "HealthyShop" :
                healthyShop.process(orderRequest);
                break;
            case "GlutenFreeShop" :
                glutenFreeShop.process(orderRequest);
                break;
            case "ExtraFoodStore" :
                extraFoodStore.process(orderRequest);
                break;
            case "SomeOtherManufacturer" :
                someOtherManufacturer.process(orderRequest);
                break;
        }
    }
}

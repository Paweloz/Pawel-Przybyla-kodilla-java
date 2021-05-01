package com.kodilla.good.patterns.food2door;

import java.util.Set;

public class GeneralProcessor {

    private final Set<Manufacturer> companies;

    public GeneralProcessor( Set<Manufacturer> companies) {
        this.companies = companies;
    }

    public void processOrder(OrderRequest orderRequest ) {
        companies.stream()
                .filter(manufacturer -> manufacturer.getShopName().equals(orderRequest.getManufacturerName()))
                .forEach(manufacturer -> manufacturer.process(orderRequest));
    }
}

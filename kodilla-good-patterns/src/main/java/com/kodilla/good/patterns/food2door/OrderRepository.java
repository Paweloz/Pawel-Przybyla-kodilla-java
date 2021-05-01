package com.kodilla.good.patterns.food2door;

import java.util.*;

public class OrderRepository {
    private final Map<String, List<OrderRequest>> generalDataBase;

    public OrderRepository(Map<String, List<OrderRequest>> generalDataBase) {
        this.generalDataBase = generalDataBase;
    }

    public void createOrder(OrderRequest orderRequest) {
        generalDataBase.entrySet().stream()
                .filter(dataBase -> dataBase.getKey().equals(orderRequest.getCompanySignature()))
                .forEach(dataBase -> {
                    dataBase.getValue().add(orderRequest);
                    System.out.println("Order number "+orderRequest.getOrderNumber()+" has been added to "+
                            dataBase.getKey()+" database");
                });
    }
}
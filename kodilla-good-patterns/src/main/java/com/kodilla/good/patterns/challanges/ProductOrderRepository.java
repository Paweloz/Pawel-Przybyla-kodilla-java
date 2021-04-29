package com.kodilla.good.patterns.challanges;

public class ProductOrderRepository implements  OrderRepository {

    public void createOrder(OrderRequest orderRequest) {
        System.out.println("Order for Customer : "+ orderRequest.getCustomer().getNickName()+" was added to repository");
    }
}

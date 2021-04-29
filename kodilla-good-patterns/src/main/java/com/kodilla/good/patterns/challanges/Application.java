package com.kodilla.good.patterns.challanges;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriver orderRequestRetriver = new OrderRequestRetriver();
        OrderRequest orderRequest = orderRequestRetriver.retrive();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(),
                new ProductOrderService(),
                new ProductOrderRepository());
        orderProcessor.process(orderRequest);
    }
}

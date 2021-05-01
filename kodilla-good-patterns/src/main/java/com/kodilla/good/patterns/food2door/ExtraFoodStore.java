package com.kodilla.good.patterns.food2door;

import java.util.Objects;

public class ExtraFoodStore implements Manufacturer {
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public ExtraFoodStore(InformationService informationService, OrderRepository orderRepository, OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        System.out.println("\nProcessing order for ExtraFoodStore");
        boolean isPlaced = orderService.placeOrder(orderRequest);
        if(isPlaced) {
            orderRepository.createOrder(orderRequest);
            informationService.sendMessage(orderRequest);
            return new OrderDto(orderRequest.getCustomer(),true);
        }
        return new OrderDto(orderRequest.getCustomer(), false);
    }

    @Override
    public String getShopName() {
        return "ExtraFoodStore";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraFoodStore that = (ExtraFoodStore) o;
        return informationService.equals(that.informationService) && orderRepository.equals(that.orderRepository) && orderService.equals(that.orderService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationService, orderRepository, orderService);
    }
}

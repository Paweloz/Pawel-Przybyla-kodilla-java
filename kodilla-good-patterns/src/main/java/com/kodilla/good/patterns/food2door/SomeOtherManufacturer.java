package com.kodilla.good.patterns.food2door;

import java.util.Objects;

public class SomeOtherManufacturer implements Manufacturer {
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public SomeOtherManufacturer(InformationService informationService, OrderRepository orderRepository, OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        System.out.println("\nProcessing order for SomeOtherManufacturer");
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
        return "SomeOtherManufacturer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeOtherManufacturer that = (SomeOtherManufacturer) o;
        return informationService.equals(that.informationService) && orderRepository.equals(that.orderRepository) && orderService.equals(that.orderService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationService, orderRepository, orderService);
    }
}

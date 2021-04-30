package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Manufacturer {
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public GlutenFreeShop(InformationService informationService, OrderRepository orderRepository, OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        System.out.println("\nProcessing order for GlutenFreeShop");
        boolean isPlaced = orderService.placeOrder(orderRequest);
        if(isPlaced) {
            orderRepository.createOrder(orderRequest);
            informationService.sendMessage(orderRequest);
            return new OrderDto(orderRequest.getCustomer(),true);
        }
        return new OrderDto(orderRequest.getCustomer(), false);
    }
}

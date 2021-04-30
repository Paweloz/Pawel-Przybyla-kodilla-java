package com.kodilla.good.patterns.food2door;

public class OrderService {
    public boolean placeOrder(OrderRequest orderRequest) {
        System.out.println("Placing following order for Customer :"+ orderRequest.getCustomer().getNickName()+
                "\n Product : "+orderRequest.getProductType()+
                "\n Manufacturer : "+orderRequest.getManufacturerName()+
                "\n Quantity : "+orderRequest.getQuantity()+
                "\n Order Time : "+orderRequest.getOrderTime());
        return true;
    }
}

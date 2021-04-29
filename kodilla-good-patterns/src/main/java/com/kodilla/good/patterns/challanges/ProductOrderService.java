package com.kodilla.good.patterns.challanges;

public class ProductOrderService implements OrderService {

    public boolean placeOrder(OrderRequest orderRequest){
        System.out.println("Placing following order for Customer "+ orderRequest.getCustomer().getNickName()+
                "\n Product : "+orderRequest.getProduct().getProductName()+
                "\n Manufacturer : "+orderRequest.getProduct().getManufacturer()+
                "\n Quantity : "+orderRequest.getQuantity()+
                "\n Order Time : "+orderRequest.getOrderTime());
        return true;
    }
}
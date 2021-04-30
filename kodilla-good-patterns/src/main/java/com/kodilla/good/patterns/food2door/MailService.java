package com.kodilla.good.patterns.food2door;

public class MailService implements InformationService {

    public void sendMessage(OrderRequest orderRequest) {
        System.out.println("Order number "+orderRequest.getOrderNumber()+
                " for "+orderRequest.getCustomer().getNickName()+" was successfully placed");
    }
}

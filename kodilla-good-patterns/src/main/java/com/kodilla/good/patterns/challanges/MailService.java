package com.kodilla.good.patterns.challanges;

public class MailService implements InformationService {

    public void sendMessage(Customer customer){
        System.out.println("Your order was successfully placed");
    }
}

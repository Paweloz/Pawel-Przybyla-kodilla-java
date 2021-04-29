package com.kodilla.good.patterns.challanges;

import java.time.LocalDateTime;

public class OrderRequestRetriver {

    public OrderRequest retrive() {
        Customer customer = new Customer("MarekTowarek", "ul. Cwiartki 3/4 Wrocław");
        Product product = new Product("Rower górski GIANT",
                "Mountain Bikes",
                23214 );
        int quantity = 1;
        LocalDateTime orderTime = LocalDateTime.of(2020,4,29,12,1);

        return new OrderRequest(customer, product, quantity, orderTime);
    }
}

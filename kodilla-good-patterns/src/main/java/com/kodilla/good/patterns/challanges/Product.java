package com.kodilla.good.patterns.challanges;

public class Product {
    private String productName;
    private String manufacturer;
    private int productID;

    public Product(String productName, String manufacturer, int productID) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getProductID() {
        return productID;
    }
}

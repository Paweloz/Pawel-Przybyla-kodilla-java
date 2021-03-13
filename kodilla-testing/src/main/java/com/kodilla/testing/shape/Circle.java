package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getShape() {
        return "Cirlce";
    }

    @Override
    public double getField() {
        return 3.14*radius*radius;
    }
}

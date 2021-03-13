package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double base;
    private double hight;

    public Triangle(double base, double hight) {
        this.base = base;
        this.hight = hight;
    }

    public double getBase() {
        return base;
    }

    public double getHight() {
        return hight;
    }

    @Override
    public String getShape() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (base*hight)/2;
    }
}

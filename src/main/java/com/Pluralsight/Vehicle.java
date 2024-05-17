package com.Pluralsight;

public class Vehicle {
    private double price;
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private String type;

    public Vehicle(double price, String make, String model, int year, String color, int mileage, String type) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "price=" + price +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", type='" + type + '\'' +
                '}';
    }
}


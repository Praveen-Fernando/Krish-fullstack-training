package com.praveen.training.prototypepattern;

public class Bike extends Vehicle{

    private String fuelType;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "fuelType='" + fuelType + '\'' +
                '}';
    }
}

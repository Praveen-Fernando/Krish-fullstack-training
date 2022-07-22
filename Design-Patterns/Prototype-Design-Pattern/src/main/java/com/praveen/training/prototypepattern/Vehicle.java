package com.praveen.training.prototypepattern;

public abstract class Vehicle implements Cloneable{

    private String VehicleType;
    private int VehiclePrice;

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public int getVehiclePrice() {
        return VehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        VehiclePrice = vehiclePrice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

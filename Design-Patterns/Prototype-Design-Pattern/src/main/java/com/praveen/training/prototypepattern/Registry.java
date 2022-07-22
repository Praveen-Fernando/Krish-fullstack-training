package com.praveen.training.prototypepattern;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<VehicleType, Vehicle> vehicleMap = new HashMap<>();

    public Registry() {
        this.initialize();
    }

    public Vehicle getVehicle(VehicleType vehicleType){
        Vehicle vehicle = null;
        try {
            vehicle = (Vehicle) vehicleMap.get(vehicleType).clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    private void initialize() {

        Car car = new Car();
        car.setVehicleType("Jeep");
        car.setVehiclePrice(15000);
        car.setBrand("BMW");

        Bike bike = new Bike();
        bike.setVehicleType("Honda");
        bike.setVehiclePrice(10000);
        bike.setFuelType("Petrol");


        vehicleMap.put(VehicleType.CAR,car);
        vehicleMap.put(VehicleType.BIKE,bike);

    }

}

package com.praveen.training.builderpattern;

public class Application {
    public static void main(String arg[]){

        Vehicle.Builder builder = new Vehicle.Builder("Full");
        Vehicle vehicle = builder.dropLocation("Kandy").roadAssistance("No").build();
        System.out.println(vehicle);
    }
}
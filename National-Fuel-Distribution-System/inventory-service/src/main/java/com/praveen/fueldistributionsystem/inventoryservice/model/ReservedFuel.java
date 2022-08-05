package com.praveen.fueldistributionsystem.inventoryservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.util.UUID;

@Document("ReservedFuel")
public class ReservedFuel {

    @Transient
    public static final String SEQUENCE_NAME = "ReservedFuel_Sequence";
    @Id
    private int orderReferenceId;

    private String orderId;
    private String fuelStationName;
    private String fuelStationNumber;
    private String fuelType;
    private int reservedFuelAmount;
    private String reservedStatus;

    public ReservedFuel() {
    }


    public ReservedFuel(String orderId, String fuelStationName, String fuelStationNumber, String fuelType, int reservedFuelAmount, String reservedStatus) {
        this.orderId = orderId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelType = fuelType;
        this.reservedFuelAmount = reservedFuelAmount;
        this.reservedStatus = reservedStatus;
    }

    public int getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(int orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public void setFuelStationName(String fuelStationName) {
        this.fuelStationName = fuelStationName;
    }

    public String getFuelStationNumber() {
        return fuelStationNumber;
    }

    public void setFuelStationNumber(String fuelStationNumber) {
        this.fuelStationNumber = fuelStationNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getReservedFuelAmount() {
        return reservedFuelAmount;
    }

    public void setReservedFuelAmount(int reservedFuelAmount) {
        this.reservedFuelAmount = reservedFuelAmount;
    }

    public String getReservedStatus() {
        return reservedStatus;
    }

    public void setReservedStatus(String reservedStatus) {
        this.reservedStatus = reservedStatus;
    }

}

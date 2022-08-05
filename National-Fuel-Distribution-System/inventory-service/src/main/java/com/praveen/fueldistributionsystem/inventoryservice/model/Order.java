package com.praveen.fueldistributionsystem.inventoryservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.UUID;

@Document("Orders")
public class Order {

//    @Transient
//    public static final String SEQUENCE_NAME = "orders_Sequence";

    @Id
    @GeneratedValue
    private String orderId;
    private String orderReferenceId;
    private String fuelStationName;
    private String fuelStationNumber;
    private int fuelTypeId;
    private int fuelCapacity;
    private String orderStatus;

    public Order() {
    }


    public Order(String orderReferenceId, String fuelStationName, String fuelStationNumber, int fuelTypeId, int fuelCapacity, String orderStatus) {
        this.orderReferenceId = orderReferenceId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelTypeId = fuelTypeId;
        this.fuelCapacity = fuelCapacity;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(String orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
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

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderReferenceId='" + orderReferenceId + '\'' +
                ", fuelStationName='" + fuelStationName + '\'' +
                ", fuelStationNumber='" + fuelStationNumber + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                ", fuelCapacity=" + fuelCapacity +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

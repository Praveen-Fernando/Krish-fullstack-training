package com.praveen.fueldistributionsystem.orderservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.UUID;

@Document("Orders")
public class Order implements Serializable {

//    @Transient
//    public static final String SEQUENCE_NAME = "orders_Sequence";

    @Id
    @GeneratedValue
    private String orderId;
    private String fuelStationName;
    private String fuelStationNumber;
    private int fuelTypeId;
    private int fuelCapacity;

    private String orderStatus;

    public Order() {
    }


    public Order(String fuelStationName, String fuelStationNumber, int fuelTypeId, int fuelCapacity, String orderStatus) {
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
                ", fuelStationName='" + fuelStationName + '\'' +
                ", fuelStationNumber='" + fuelStationNumber + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                ", fuelCapacity=" + fuelCapacity +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

package com.praveen.fueldistributionsystem.inventoryservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.time.LocalDate;


@Document("Orders")
public class Order {

//    @Transient
//    public static final String SEQUENCE_NAME = "orders_Sequence";

    @Id
    @GeneratedValue
    private String orderId;

    private int orderReferenceId;

    private String fuelStationName;
    private String fuelStationNumber;
    private int fuelTypeId;
    private String fuelType;
    private int fuelCapacity;
    private LocalDate date;

    private LocalDate dispatchDate;
    private String orderStatus;

    public Order() {
    }

    public Order(int orderReferenceId, String fuelStationName, String fuelStationNumber, int fuelTypeId, String fuelType, int fuelCapacity, LocalDate date, LocalDate dispatchDate, String orderStatus) {
        this.orderReferenceId = orderReferenceId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.date = date;
        this.dispatchDate = dispatchDate;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(int orderReferenceId) {
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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
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
                "orderId='" + orderId + '\'' +
                ", fuelStationName='" + fuelStationName + '\'' +
                ", fuelStationNumber='" + fuelStationNumber + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                ", fuelCapacity=" + fuelCapacity +
                ", date=" + date +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

package com.praveen.fueldistributionsystem.scheduleservice.model;

import org.springframework.data.annotation.Id;
import javax.persistence.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document("Schedule")
public class Schedule {

    @Transient
    public static final String SEQUENCE_NAME = "Delivery_Sequence";
    @Id
    private int orderScheduleId;

    private int orderReferenceId;
    private String orderId;
    private String fuelStationName;
    private String fuelStationNumber;
    private String fuelType;
    private int reservedFuelAmount;
    private LocalDate deliveryDate;
    private String scheduleStatus;

    public Schedule() {
    }


    public Schedule(int orderReferenceId, String orderId, String fuelStationName, String fuelStationNumber, String fuelType, int reservedFuelAmount, LocalDate deliveryDate, String scheduleStatus) {
        this.orderReferenceId = orderReferenceId;
        this.orderId = orderId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelType = fuelType;
        this.reservedFuelAmount = reservedFuelAmount;
        this.deliveryDate = deliveryDate;
        this.scheduleStatus = scheduleStatus;
    }

    public int getOrderScheduleId() {
        return orderScheduleId;
    }

    public void setOrderScheduleId(int orderScheduleId) {
        this.orderScheduleId = orderScheduleId;
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

}

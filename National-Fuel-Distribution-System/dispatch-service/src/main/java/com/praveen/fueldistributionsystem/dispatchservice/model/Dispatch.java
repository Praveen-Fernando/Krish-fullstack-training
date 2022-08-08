package com.praveen.fueldistributionsystem.dispatchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;

@Document("Dispatch")
public class Dispatch {

    @Id
    @GeneratedValue
    private String dispatchId;
    private LocalDate dispatchDate;
    private String orderStatus;

    public Dispatch() {
    }

    public Dispatch(LocalDate dispatchDate, String orderStatus) {
        this.dispatchDate = dispatchDate;
        this.orderStatus = orderStatus;
    }

    public String getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(String dispatchId) {
        this.dispatchId = dispatchId;
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
        return "Dispatch{" +
                "dispatchId='" + dispatchId + '\'' +
                ", dispatchDate=" + dispatchDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

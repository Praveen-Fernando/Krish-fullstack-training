package com.praveen.fueldistributionsystem.orderservice.service;

import com.praveen.fueldistributionsystem.orderservice.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> viewOrderById(String orderId);

    List<Order> findByOrderId(String orderId);

    List<Order> findAllByOrderStatus(String orderStatus);
}

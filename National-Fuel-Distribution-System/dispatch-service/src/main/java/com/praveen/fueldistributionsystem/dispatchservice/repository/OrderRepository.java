package com.praveen.fueldistributionsystem.dispatchservice.repository;

import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByOrderId(String orderId);

//  List<Order> findAll(String orderStatus);
    List<Order> findAllByOrderStatus(String orderStatus);
}
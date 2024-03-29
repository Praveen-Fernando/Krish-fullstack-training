package com.praveen.fueldistributionsystem.orderservice.repository;

import com.praveen.fueldistributionsystem.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByOrderId(String orderId);

    List<Order> findAllByOrderStatus(String orderStatus);

//    List<Order> callDispatch(String orderId);
}

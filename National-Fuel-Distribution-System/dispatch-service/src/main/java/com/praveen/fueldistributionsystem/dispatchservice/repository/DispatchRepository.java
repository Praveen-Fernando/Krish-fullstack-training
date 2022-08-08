package com.praveen.fueldistributionsystem.dispatchservice.repository;

import com.praveen.fueldistributionsystem.dispatchservice.model.Dispatch;
import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatchRepository extends MongoRepository<Dispatch, String> {
    List<Order> findByOrderId(String orderId);
}

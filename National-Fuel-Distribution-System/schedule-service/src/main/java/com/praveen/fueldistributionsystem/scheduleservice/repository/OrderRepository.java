package com.praveen.fueldistributionsystem.scheduleservice.repository;


import com.praveen.fueldistributionsystem.scheduleservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}

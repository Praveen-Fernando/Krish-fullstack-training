package com.praveen.fueldistributionsystem.inventoryservice.Repository;


import com.praveen.fueldistributionsystem.inventoryservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}

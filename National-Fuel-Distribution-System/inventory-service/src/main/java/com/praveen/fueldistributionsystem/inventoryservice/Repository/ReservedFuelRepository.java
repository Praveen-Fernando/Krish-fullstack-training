package com.praveen.fueldistributionsystem.inventoryservice.Repository;

import com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservedFuelRepository extends MongoRepository<ReservedFuel, String> {
}

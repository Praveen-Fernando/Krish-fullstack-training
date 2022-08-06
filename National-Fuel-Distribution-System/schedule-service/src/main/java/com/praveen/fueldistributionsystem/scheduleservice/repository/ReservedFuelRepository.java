package com.praveen.fueldistributionsystem.scheduleservice.repository;

import com.praveen.fueldistributionsystem.scheduleservice.model.ReservedFuel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedFuelRepository extends MongoRepository<ReservedFuel, String> {
}

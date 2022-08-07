package com.praveen.fueldistributionsystem.scheduleservice.repository;

import com.praveen.fueldistributionsystem.scheduleservice.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, Integer> {

    List<Schedule> findByOrderId(String orderId);
}


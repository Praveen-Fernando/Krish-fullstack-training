package com.praveen.fueldistributionsystem.scheduleservice.repository;

import com.praveen.fueldistributionsystem.scheduleservice.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, Integer> {
}

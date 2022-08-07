package com.praveen.fueldistributionsystem.scheduleservice.service;

import com.praveen.fueldistributionsystem.scheduleservice.model.Schedule;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ScheduleService {
    List<Schedule> viewAll();

    List<Schedule> findByOrderId(String orderId);

}

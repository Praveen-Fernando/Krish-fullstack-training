package com.praveen.fueldistributionsystem.scheduleservice.controller;

import com.praveen.fueldistributionsystem.scheduleservice.model.Schedule;
import com.praveen.fueldistributionsystem.scheduleservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/scheduled")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public List<Schedule> viewAll(){
        return scheduleService.viewAll();
    }

    @RequestMapping(value = "/viewById/{id}", method = RequestMethod.GET)
    public List<Schedule> findByOrderId(@PathVariable("id") String orderId){
        return scheduleService.findByOrderId(orderId);
    }
}

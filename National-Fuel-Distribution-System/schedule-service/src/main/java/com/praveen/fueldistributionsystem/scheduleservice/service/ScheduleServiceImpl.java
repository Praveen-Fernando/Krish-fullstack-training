package com.praveen.fueldistributionsystem.scheduleservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.scheduleservice.model.ReservedFuel;
import com.praveen.fueldistributionsystem.scheduleservice.model.Schedule;
import com.praveen.fueldistributionsystem.scheduleservice.repository.ReservedFuelRepository;
import com.praveen.fueldistributionsystem.scheduleservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.praveen.fueldistributionsystem.scheduleservice.model.Schedule.SEQUENCE_NAME;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Value("${reserve.topic.name}")
    private String reserveTopicName;

    @Autowired
    ReservedFuelRepository reservedFuelRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "reserved-topic",groupId = "groupId")
    @Scheduled(initialDelay = 10000)
    public void processSchedule(String message){
        System.out.println("Received Message : " + message);
        try {
            ReservedFuel reservedFuel = objectMapper.readValue(message, ReservedFuel.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>"+reservedFuel.getReservedStatus());

            if(reservedFuel.getReservedStatus().equals("FUEL ALLOCATED")) {
                reservedFuel.setReservedStatus("DELIVERY SCHEDULED");
                Schedule schedule = new Schedule();
                schedule.setOrderScheduleId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
                schedule.setOrderReferenceId(reservedFuel.getOrderReferenceId());
                schedule.setOrderId(reservedFuel.getOrderId());
                schedule.setFuelStationName(reservedFuel.getFuelStationName());
                schedule.setFuelStationNumber(reservedFuel.getFuelStationNumber());
                schedule.setFuelType(reservedFuel.getFuelType());
                schedule.setReservedFuelAmount(reservedFuel.getReservedFuelAmount());
                schedule.setDeliveryDate(sequenceGeneratorService.generateLocalDate()); //random date need to add
                schedule.setScheduleStatus("DELIVERY SCHEDULED");
                reservedFuelRepository.save(reservedFuel);
                scheduleRepository.save(schedule);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Schedule> viewAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findByOrderId(String orderId) {
        List<Schedule> schedules = new ArrayList<>();
        return scheduleRepository.findByOrderId(orderId);
    }
}

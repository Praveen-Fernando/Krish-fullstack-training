package com.praveen.fueldistributionsystem.dispatchservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.dispatchservice.model.Dispatch;
import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import com.praveen.fueldistributionsystem.dispatchservice.repository.DispatchRepository;
import com.praveen.fueldistributionsystem.dispatchservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DispatchServiceImpl implements DispatchService {

    @Value("${dispatch.topic.name}")
    String dispatchTopic;

    @Autowired
    DispatchRepository dispatchRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Optional<Dispatch> dispatchOrder(Dispatch dispatch) {
        dispatch.setOrderStatus("ORDER DISPATCHED");
        LocalDate localDate = LocalDate.now();
        dispatch.setDispatchDate(localDate);

        dispatch = dispatchRepository.save(dispatch);

        String dispatchOrder = null;
        try {
            dispatchOrder = objectMapper.writeValueAsString(dispatch);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send(dispatchTopic, dispatchOrder);
        System.out.println(dispatchOrder);
        System.out.println(dispatch);

        return Optional.of(dispatch);
    }

    @Override
    public List<Order> findByOrderId(String orderId) {
        List<Order> schedules = new ArrayList<>();
        return orderRepository.findByOrderId(orderId);
    }

}

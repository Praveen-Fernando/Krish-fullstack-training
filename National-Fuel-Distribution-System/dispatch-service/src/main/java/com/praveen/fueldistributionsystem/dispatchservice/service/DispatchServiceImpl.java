package com.praveen.fueldistributionsystem.dispatchservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import com.praveen.fueldistributionsystem.dispatchservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class DispatchServiceImpl implements DispatchService {

    @Value("${dispatch.topic.name}")
    String dispatchTopic;

    @Autowired
    OrderRepository orderRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "dispatch-topics",groupId = "groupId")
    public void processDispatch(String message){
        System.out.println("Received Message : " + message);
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>"+order.getOrderId());

            order.setOrderStatus("ORDER DISPATCHED");
            LocalDate localDate = LocalDate.now();
            order.setDispatchDate(localDate);
            orderRepository.save(order);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

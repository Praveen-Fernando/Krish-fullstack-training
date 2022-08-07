package com.praveen.fueldistributionsystem.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.orderservice.model.Order;
import com.praveen.fueldistributionsystem.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Value("${order.topic.name}")
    String topicName;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Order createOrder(Order order) {
        order.setOrderStatus("ORDER CREATED");
        order =  orderRepository.save(order);
        String orderStr = null;
        try {
            orderStr = objectMapper.writeValueAsString(order);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,orderStr);
        System.out.println(orderStr);
        System.out.println(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> viewOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

}

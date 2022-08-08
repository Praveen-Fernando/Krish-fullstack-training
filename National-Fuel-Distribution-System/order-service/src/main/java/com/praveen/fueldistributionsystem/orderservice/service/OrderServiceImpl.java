package com.praveen.fueldistributionsystem.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.orderservice.model.Dispatch;
import com.praveen.fueldistributionsystem.orderservice.model.Order;
import com.praveen.fueldistributionsystem.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Value("${order.topic.name}")
    String topicName;

    @Value("${dispatch.topic.name}")
    String dispatchTopic;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Order createOrder(Order order) {
        order.setOrderStatus("ORDER CREATED");
        order.setDispatchDate(null);
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

    @Override
    public List<Order> findByOrderId(String orderId) {
        List<Order> schedules = new ArrayList<>();
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order> findAllByOrderStatus(String orderStatus) {
        List<Order> status = orderRepository.findAllByOrderStatus("DELIVERY SCHEDULED");
        return status;
    }

    @KafkaListener(topics = "dispatch-topic",groupId = "groupId")
    public void processDispatch(String message){
        System.out.println("Received Message : " + message);
        try {
            Dispatch dispatch = objectMapper.readValue(message, Dispatch.class);
            System.out.println(">>>>>>>From Dispatch>>>>>>>>>>>>>"+dispatch);
            Order order = orderRepository.findById(dispatch.getDispatchId()).get();
            order.setOrderStatus(dispatch.getOrderStatus());
            order.setDispatchDate(dispatch.getDispatchDate());
            orderRepository.save(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

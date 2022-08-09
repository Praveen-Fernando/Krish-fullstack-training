package com.praveen.fueldistributionsystem.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.orderservice.model.Order;
import com.praveen.fueldistributionsystem.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

//    @Override
//    public Optional<Order> viewOrderById(String orderId) {
//        return orderRepository.findById(orderId);
//    }

    @Override
    public List<Order> findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order> confirmOrder(String orderId) {
        List<Order> listOrder;

        listOrder = orderRepository.findByOrderId(orderId);
        Order order = listOrder.get(0);
        order.setOrderStatus("ORDER RECEIVED");
        orderRepository.save(order);
        return listOrder;
    }

    @Override
    public List<Order> findAllByOrderStatus(String orderStatus) {
        List<Order> status = orderRepository.findAllByOrderStatus("DELIVERY SCHEDULED");
        return status;
    }

    @Override
    public List<Order> callDispatch(String orderId) {
        List<Order> schedules;

        schedules = orderRepository.findByOrderId(orderId);
        Order order = schedules.get(0);
        order.setDispatchDate(null);
        String dispatchOrder = null;
        try {
            dispatchOrder = objectMapper.writeValueAsString(order);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send(dispatchTopic, dispatchOrder);

        return schedules;
    }
}

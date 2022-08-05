package com.praveen.fueldistributionsystem.orderservice.controller;

import com.praveen.fueldistributionsystem.orderservice.model.Order;
import com.praveen.fueldistributionsystem.orderservice.service.OrderService;
import com.praveen.fueldistributionsystem.orderservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
//import static com.praveen.fueldistributionsystem.orderservice.model.Order.SEQUENCE_NAME;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order){
//        order.setOrderId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/viewOrder/{id}", method = RequestMethod.GET)
    public Optional<Order> viewOrderById(@PathVariable("id") String orderId){
        return orderService.viewOrderById(orderId);
    }
}

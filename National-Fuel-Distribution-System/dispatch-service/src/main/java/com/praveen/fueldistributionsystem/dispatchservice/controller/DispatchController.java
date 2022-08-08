package com.praveen.fueldistributionsystem.dispatchservice.controller;

import com.praveen.fueldistributionsystem.dispatchservice.model.Dispatch;
import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import com.praveen.fueldistributionsystem.dispatchservice.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/dispatch")
public class DispatchController {

    @Autowired
    DispatchService dispatchService;

//    @RequestMapping(value = "/{orderID}", method = RequestMethod.GET)
//    public Optional<Dispatch> dispatchOrder(@PathVariable("orderID") String orderID, @RequestBody Dispatch dispatch){
//        return dispatchService.dispatchOrder(dispatch);
//
//    }

    @RequestMapping(value = "/viewById/{id}", method = RequestMethod.GET)
    public List<Order> findByOrderId(@PathVariable("id") String orderId){
        return dispatchService.findByOrderId(orderId);
    }
}

package com.praveen.fueldistributionsystem.dispatchservice.service;

import com.praveen.fueldistributionsystem.dispatchservice.model.Dispatch;
import com.praveen.fueldistributionsystem.dispatchservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DispatchService {


   Optional<Dispatch> dispatchOrder(Dispatch dispatch);
   List<Order> findByOrderId(String orderId);
}

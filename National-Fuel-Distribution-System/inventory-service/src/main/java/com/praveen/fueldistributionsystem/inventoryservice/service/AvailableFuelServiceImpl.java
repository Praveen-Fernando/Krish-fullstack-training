package com.praveen.fueldistributionsystem.inventoryservice.service;

import com.praveen.fueldistributionsystem.inventoryservice.Repository.AvailableFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.model.AvailableFuel;
import com.praveen.fueldistributionsystem.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AvailableFuelServiceImpl implements AvailableFuelService {

    @Autowired
    private AvailableFuelRepository availableFuelRepository;

    public AvailableFuel addFuel(AvailableFuel availableFuel){
        return availableFuelRepository.save(availableFuel);
    }

    public List<AvailableFuel> getFuel(){
        return availableFuelRepository.findAll();
    }

}

package com.praveen.fueldistributionsystem.inventoryservice.service;

import com.praveen.fueldistributionsystem.inventoryservice.model.AvailableFuel;
import com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    AvailableFuel addFuel(AvailableFuel availableFuel);

    List<AvailableFuel> getFuel();

    List<ReservedFuel> viewAllStatus();
}

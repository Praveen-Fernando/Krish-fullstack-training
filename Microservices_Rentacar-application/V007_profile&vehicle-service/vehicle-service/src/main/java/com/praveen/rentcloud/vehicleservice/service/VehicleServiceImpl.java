package com.praveen.rentcloud.vehicleservice.service;

import com.praveen.rentcloud.commons.model.Vehicle;
import com.praveen.rentcloud.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
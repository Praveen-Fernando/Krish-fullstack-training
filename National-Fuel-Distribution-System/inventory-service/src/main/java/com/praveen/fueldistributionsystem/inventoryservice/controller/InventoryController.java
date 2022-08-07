package com.praveen.fueldistributionsystem.inventoryservice.controller;

import com.praveen.fueldistributionsystem.inventoryservice.Repository.ReservedFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel;
import com.praveen.fueldistributionsystem.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/allocation")
public class InventoryController {


    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public List<ReservedFuel> viewAllStatus(){
        return inventoryService.viewAllStatus();
    }


}

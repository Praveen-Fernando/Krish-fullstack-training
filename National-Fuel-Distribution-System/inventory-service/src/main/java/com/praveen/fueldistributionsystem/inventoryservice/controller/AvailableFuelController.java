package com.praveen.fueldistributionsystem.inventoryservice.controller;

import com.praveen.fueldistributionsystem.inventoryservice.model.AvailableFuel;
import com.praveen.fueldistributionsystem.inventoryservice.service.AvailableFuelService;
//import com.praveen.fueldistributionsystem.inventoryservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import static com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel.SEQUENCE_NAME;

@RestController
@RequestMapping(value = "/fuelStation")
public class AvailableFuelController {

    @Autowired
    AvailableFuelService availableFuelService;


//    @RequestMapping(value = "/addFuel", method = RequestMethod.POST)
//    public AvailableFuel addFuel(@RequestBody AvailableFuel availableFuel){
//        availableFuel.setFuelTypeId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
//        return availableFuelService.addFuel(availableFuel);
//    }
//
//    @RequestMapping(value = "/getFuel", method = RequestMethod.GET)
//    public List<AvailableFuel> getFuel(){
//        return availableFuelService.getFuel();
//    }


}

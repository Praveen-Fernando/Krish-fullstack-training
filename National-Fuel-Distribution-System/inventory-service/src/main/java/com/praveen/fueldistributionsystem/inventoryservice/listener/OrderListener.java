package com.praveen.fueldistributionsystem.inventoryservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.AvailableFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.OrderRepository;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.ReservedFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.model.AvailableFuel;
import com.praveen.fueldistributionsystem.inventoryservice.model.Order;
import com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel;
import com.praveen.fueldistributionsystem.inventoryservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel.SEQUENCE_NAME;

@EnableKafka
@Service
public class OrderListener {

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AvailableFuelRepository availableFuelRepository;

    @Autowired
    ReservedFuelRepository reservedFuelRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "orders-topic",groupId = "groupId")
    public void processOrder(String message){
        System.out.println("Received Message : " + message);
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>"+order);
            AvailableFuel availableFuel = availableFuelRepository.findById(order.getFuelTypeId()).get();
            System.out.println("++++++++++++++++++++++++++++"+availableFuel);

            if(availableFuel.getAvailableFuelCapacity() > order.getFuelCapacity()){
                order.setOrderStatus("ALLOCATION COMPLETE");
                availableFuel.setAvailableFuelCapacity(availableFuel.getAvailableFuelCapacity() - order.getFuelCapacity());

                if(order.getOrderStatus().equals("ALLOCATION COMPLETE")){
                    ReservedFuel reservedFuel = new ReservedFuel();
                    reservedFuel.setOrderReferenceId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
                    reservedFuel.setOrderId(order.getOrderId());
                    reservedFuel.setFuelStationName(order.getFuelStationName());
                    reservedFuel.setFuelStationNumber(order.getFuelStationNumber());
                    reservedFuel.setFuelType(availableFuel.getFuelType());
                    reservedFuel.setReservedFuelAmount(order.getFuelCapacity());
                    reservedFuel.setReservedStatus("FUEL ALLOCATED");
                    reservedFuelRepository.save(reservedFuel);
                }
                orderRepository.save(order);
                availableFuelRepository.save(availableFuel);

                System.out.println("Fuel Type : "+availableFuel.getFuelType()+"\n"+"Updated : " +availableFuel.getAvailableFuelCapacity());

            }else {
                order.setOrderStatus("ALLOCATION FAILED");
                orderRepository.save(order);
            }
            orderRepository.save(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
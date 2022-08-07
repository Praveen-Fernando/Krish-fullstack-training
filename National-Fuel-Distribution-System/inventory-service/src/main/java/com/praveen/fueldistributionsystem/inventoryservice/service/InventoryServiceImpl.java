package com.praveen.fueldistributionsystem.inventoryservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.AvailableFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.OrderRepository;
import com.praveen.fueldistributionsystem.inventoryservice.Repository.ReservedFuelRepository;
import com.praveen.fueldistributionsystem.inventoryservice.model.AvailableFuel;
import com.praveen.fueldistributionsystem.inventoryservice.model.Order;
import com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import static com.praveen.fueldistributionsystem.inventoryservice.model.ReservedFuel.SEQUENCE_NAME;
import java.util.List;

@EnableKafka
@Service
public class InventoryServiceImpl implements InventoryService {


    @Value("${order.topic.name}")
    private String topicName;

    @Value("${reserve.topic.name}")
    private String reserveTopicName;


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AvailableFuelRepository availableFuelRepository;

    @Autowired
    ReservedFuelRepository reservedFuelRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

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
                ReservedFuel reservedFuel = new ReservedFuel();
                availableFuel.setAvailableFuelCapacity(availableFuel.getAvailableFuelCapacity() - order.getFuelCapacity());
                orderRepository.save(order);

                if(order.getOrderStatus().equals("ALLOCATION COMPLETE")){
                    reservedFuel.setOrderReferenceId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
                    reservedFuel.setOrderId(order.getOrderId());
                    reservedFuel.setFuelStationName(order.getFuelStationName());
                    reservedFuel.setFuelStationNumber(order.getFuelStationNumber());
                    reservedFuel.setFuelType(availableFuel.getFuelType());
                    reservedFuel.setReservedFuelAmount(order.getFuelCapacity());
                    reservedFuel.setReservedStatus("FUEL ALLOCATED");
                    reservedFuelRepository.save(reservedFuel);
                }

                String orderStr = null;
                try {
                    orderStr = objectMapper.writeValueAsString(reservedFuel);
                }catch (JsonProcessingException e){
                    e.printStackTrace();
                }
                kafkaTemplate.send(reserveTopicName,orderStr);
                System.out.println(">>>>>>>>>" +orderStr);

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

    public AvailableFuel addFuel(AvailableFuel availableFuel){
        return availableFuelRepository.save(availableFuel);
    }

    public List<AvailableFuel> getFuel(){
        return availableFuelRepository.findAll();
    }

    @Override
    public List<ReservedFuel> viewAllStatus() {
        return reservedFuelRepository.findAll();
    }
}

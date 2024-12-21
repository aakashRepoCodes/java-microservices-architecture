package com.mservices.orderservice.service;

import com.example.kafka.SimpleOrder;
import com.mservices.orderservice.client.InventoryClient;
import com.mservices.orderservice.dto.OrderPlaced;
import com.mservices.orderservice.dto.OrderRequest;
import com.mservices.orderservice.model.Order;
import com.mservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final KafkaOrderService kafkaOrderService;


    public void placeOrder(OrderRequest orderRequest) {

        if (inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity())) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.getPrice());
            order.setQuantity(orderRequest.getQuantity());
            orderRepository.save(order);

            /*com.example.kafka.Order orderPlaced = com.example.kafka.Order.newBuilder()
                    .setEmail("some@gmail.com")
                    .setSkuCode("skuCode123")
                    .build();*/

            try {
                kafkaOrderService.sendOrderEvent("event");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            throw new RuntimeException("Inventory has no stocks available for this product");
        }
    }
}

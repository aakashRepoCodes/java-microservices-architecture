package com.mservices.orderservice.service;

import com.mservices.orderservice.client.InventoryClient;
import com.mservices.orderservice.dto.OrderRequest;
import com.mservices.orderservice.event.SimpleOrder;
import com.mservices.orderservice.model.Order;
import com.mservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final KafkaOrderService kafkaOrderService;


    public String placeOrder(OrderRequest orderRequest) {

        if (inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity())) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.getPrice());
            order.setQuantity(orderRequest.getQuantity());
            orderRepository.save(order);

           var OderEvent = SimpleOrder.newBuilder()
                    .setEmail("some@gmail.com")
                    .setOrderId(order.getOrderNumber().toString())
                    .build();

            try {
                kafkaOrderService.sendOrderEvent(OderEvent);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return "Order placed successfully !";

        } else {
            return "Inventory has no stocks available for this product";
            //throw new RuntimeException("Inventory has no stocks available for this product");
        }
    }
}

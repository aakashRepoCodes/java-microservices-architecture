package com.mservices.orderservice.service;

import com.mservices.orderservice.dto.OrderItemsDTO;
import com.mservices.orderservice.dto.OrderRequest;
import com.mservices.orderservice.model.Order;
import com.mservices.orderservice.model.OrderItem;
import com.mservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItem> ordersList = orderRequest.getOrderItemsDTOList()
                .stream()
                .map(this::mapToOrder)
                .toList();

        order.setOrderItemList(ordersList);
        orderRepository.save(order);
    }

    private OrderItem mapToOrder(OrderItemsDTO orderRequest) {
        OrderItem order = new OrderItem();
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setSkuCode(orderRequest.getSkuCode());
        return order;
    }
}

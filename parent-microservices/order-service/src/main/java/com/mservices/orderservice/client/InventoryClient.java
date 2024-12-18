package com.mservices.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory" ,url = "http://localhost:8084")
public interface InventoryClient {

    @GetMapping
    boolean isInStock(
            @RequestParam(value = "skuCode") String skuCode,
                      @RequestParam(value = "quantity") Integer quantity
    );

}

package com.mservices.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderPlaced {

    public String skuCode;
    public String email;

}

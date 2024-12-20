package com.mservices.orderservice.dto;


import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {
    public String skuCode;
    public BigDecimal price;
    public Integer quantity;

}
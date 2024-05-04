package com.mservices.orderservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String orderNumber;
    @OneToMany (cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

}

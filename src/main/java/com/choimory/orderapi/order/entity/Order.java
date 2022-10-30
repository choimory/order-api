package com.choimory.orderapi.order.entity;

import com.choimory.orderapi.order.enums.OrderStatus;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String address;
}

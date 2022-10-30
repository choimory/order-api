package com.choimory.orderapi.order.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.entity.Item;
import com.choimory.orderapi.order.enums.OrderStatus;

import javax.persistence.*;

@Entity
public class Order extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String address;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}

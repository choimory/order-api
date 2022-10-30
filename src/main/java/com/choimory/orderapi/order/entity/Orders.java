package com.choimory.orderapi.order.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.entity.Item;
import com.choimory.orderapi.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Orders extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String orderer;
    private String address;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder(toBuilder = true)
    public Orders(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, OrderStatus status, String orderer, String address, Item item) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.status = status;
        this.orderer = orderer;
        this.address = address;
        this.item = item;
    }

    public void orderToAccept(){
        this.status = OrderStatus.ACCEPT;
    }

    public void orderToComplete(){
        this.status = OrderStatus.COMPLETE;
    }
}

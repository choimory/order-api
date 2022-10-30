package com.choimory.orderapi.order.dto.dto;

import com.choimory.orderapi.item.dto.dto.ItemDto;
import com.choimory.orderapi.order.entity.Orders;
import com.choimory.orderapi.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDto {
    private Long id;
    private OrderStatus status;
    private String orderer;
    private String address;
    private ItemDto item;

    public static OrderDto toDto(Orders orders){
        return OrderDto.builder()
                .id(orders.getId())
                .status(orders.getStatus())
                .orderer(orders.getOrderer())
                .address(orders.getAddress())
                .item(ItemDto.toDto(orders.getItem()))
                .build();
    }
}

package com.choimory.orderapi.order.dto.request;

import com.choimory.orderapi.order.enums.OrderStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RequestFindOrders {
    private final OrderStatus status;
    private final String orderer;
    private final String address;
}

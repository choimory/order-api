package com.choimory.orderapi.order.dto.response;

import com.choimory.orderapi.order.dto.dto.OrderDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class ResponseFindOrder {
    private final OrderDto order;
}

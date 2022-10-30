package com.choimory.orderapi.order.dto.response;

import com.choimory.orderapi.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@RequiredArgsConstructor
@Getter
public class ResponseFindOrders {
    private final PaginationOfFindOrders pagination;
    private final List<OrderOfFindOrders> orders;

    @Builder
    @RequiredArgsConstructor
    @Getter
    public static class PaginationOfFindOrders{
        private final int page;
        private final int size;
        private final Long totalCount;
        private final int totalPage;
    }

    @Builder
    @RequiredArgsConstructor
    @Getter
    public static class OrderOfFindOrders{
        private final Long id;
        private final OrderStatus status;
        private final String orderer;
        private final String address;
    }
}

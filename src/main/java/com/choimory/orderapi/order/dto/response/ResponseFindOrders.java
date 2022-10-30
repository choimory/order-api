package com.choimory.orderapi.order.dto.response;

import com.choimory.orderapi.order.enums.OrderStatus;
import lombok.*;

import java.util.List;

@Builder
@RequiredArgsConstructor
@Getter
public class ResponseFindOrders {
    private final PaginationOfFindOrders pagination;
    private final List<OrderOfFindOrders> orders;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class PaginationOfFindOrders{
        private int page;
        private int size;
        private Long totalCount;
        private int totalPage;
        private String sort;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class OrderOfFindOrders{
        private Long id;
        private OrderStatus status;
        private String orderer;
        private String address;
    }
}

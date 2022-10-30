package com.choimory.orderapi.order.controller;

import com.choimory.orderapi.common.dto.request.CommonPageRequest;
import com.choimory.orderapi.order.dto.request.RequestFindOrders;
import com.choimory.orderapi.order.dto.response.ResponseAcceptOrder;
import com.choimory.orderapi.order.dto.response.ResponseCompleteOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrders;
import com.choimory.orderapi.order.enums.OrderDefaultSort;
import com.choimory.orderapi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Validated
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseFindOrders findOrders(final CommonPageRequest pageRequest,
                                         @Valid final RequestFindOrders param){
        return orderService.findOrders(pageRequest.of(OrderDefaultSort.FIND_ORDERS.getProperty(),
                    OrderDefaultSort.FIND_ORDERS.getDirection()),
                param);
    }

    @GetMapping("/{orderId}")
    public ResponseFindOrder findOrder(@PathVariable
                                           @Valid
                                           @Min(1) final Long orderId){
        return orderService.findOrder(orderId);
    }

    @PatchMapping("/{orderId}/accept")
    public ResponseAcceptOrder acceptOrder(@PathVariable
                                               @Valid
                                               @Min(1) final Long orderId){
        return orderService.acceptOrder(orderId);
    }

    @PatchMapping("/{orderId}/complete")
    public ResponseCompleteOrder completeOrder(@PathVariable
                                                   @Valid
                                                   @Min(1) final Long orderId){
        return orderService.completeOrder(orderId);
    }
}

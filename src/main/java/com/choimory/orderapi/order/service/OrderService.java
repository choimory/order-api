package com.choimory.orderapi.order.service;

import com.choimory.orderapi.common.exception.CommonException;
import com.choimory.orderapi.order.dto.dto.OrderDto;
import com.choimory.orderapi.order.dto.request.RequestFindOrders;
import com.choimory.orderapi.order.dto.response.ResponseAcceptOrder;
import com.choimory.orderapi.order.dto.response.ResponseCompleteOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrders;
import com.choimory.orderapi.order.entity.Orders;
import com.choimory.orderapi.order.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrdersRepository ordersRepository;

    public ResponseFindOrders findOrders(final Pageable pageable, final RequestFindOrders param){
        Page<ResponseFindOrders.OrderOfFindOrders> orders = ordersRepository.findOrders(pageable, param);

        return ResponseFindOrders.builder()
                .pagination(orders == null
                        ? null
                        : ResponseFindOrders.PaginationOfFindOrders.builder()
                        .page(orders.getNumber() + 1)
                        .size(orders.getSize())
                        .totalCount(orders.getTotalElements())
                        .totalPage(orders.getTotalPages())
                        .build())
                .orders(orders == null
                        ? null
                        : orders.getContent())
                .build();
    }

    public ResponseFindOrder findOrder(final Long orderId){
        OrderDto order = OrderDto.toDto(ordersRepository.findById(orderId)
                .orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        HttpStatus.NOT_FOUND.getReasonPhrase())));

        return ResponseFindOrder.builder()
                .order(order)
                .build();
    }

    @Transactional
    public ResponseAcceptOrder acceptOrder(final Long orderId){
        Orders orders = ordersRepository.findById(orderId)
                .orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        HttpStatus.NOT_FOUND.getReasonPhrase()));

        orders.orderToAccept();

        return ResponseAcceptOrder.builder()
                .acceptedOrder(OrderDto.toDto(orders))
                .build();
    }

    @Transactional
    public ResponseCompleteOrder completeOrder(final Long orderId){
        Orders orders = ordersRepository.findById(orderId)
                .orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        HttpStatus.NOT_FOUND.getReasonPhrase()));

        orders.orderToComplete();

        return ResponseCompleteOrder.builder()
                .completedOrder(OrderDto.toDto(orders))
                .build();
    }
}

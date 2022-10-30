package com.choimory.orderapi.order.service;

import com.choimory.orderapi.order.dto.request.RequestFindOrders;
import com.choimory.orderapi.order.dto.response.ResponseAcceptOrder;
import com.choimory.orderapi.order.dto.response.ResponseCompleteOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrder;
import com.choimory.orderapi.order.dto.response.ResponseFindOrders;
import com.choimory.orderapi.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    public ResponseFindOrders findOrders(final Pageable pageable, final RequestFindOrders param){
        return null;
    }

    public ResponseFindOrder findOrder(final Long orderId){
        return null;
    }

    @Transactional
    public ResponseAcceptOrder acceptOrder(final Long orderId){
        return null;
    }

    @Transactional
    public ResponseCompleteOrder completeOrder(final Long orderId){
        return null;
    }
}

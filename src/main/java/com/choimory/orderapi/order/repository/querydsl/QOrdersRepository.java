package com.choimory.orderapi.order.repository.querydsl;

import com.choimory.orderapi.order.dto.request.RequestFindOrders;
import com.choimory.orderapi.order.dto.response.ResponseFindOrders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QOrdersRepository {
    Page<ResponseFindOrders.OrderOfFindOrders> findOrders(final Pageable pageable, final RequestFindOrders param);
}

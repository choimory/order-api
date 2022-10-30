package com.choimory.orderapi.order.repository.querydsl;

import com.choimory.orderapi.order.dto.request.RequestFindOrders;
import com.choimory.orderapi.order.dto.response.ResponseFindOrders;
import com.choimory.orderapi.order.entity.QOrder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.choimory.orderapi.order.entity.QOrder.order;

@Repository
@RequiredArgsConstructor
public class QOrderRepositoryImpl implements QOrderRepository{
    private final JPAQueryFactory query;

    @Override
    public Page<ResponseFindOrders.OrderOfFindOrders> findOrders(final Pageable pageable, final RequestFindOrders param) {
        List<Long> count = query.select(Projections.constructor(Long.class, order.id))
                .from(order)
                .fetch();

        List<ResponseFindOrders.OrderOfFindOrders> orders = query.select(Projections.fields(ResponseFindOrders.OrderOfFindOrders.class,
                order.id, order.status, order.orderer, order.address))
                .from(order)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(orders, pageable, count.size());
    }
}

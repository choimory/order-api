package com.choimory.orderapi.order.repository.querydsl.expression;

import com.choimory.orderapi.order.entity.QOrders;
import com.choimory.orderapi.order.enums.OrderStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.util.StringUtils;

import static com.choimory.orderapi.order.entity.QOrders.orders;

public class OrderExpression {
    public static BooleanExpression containsOrderer(String orderer){
        return StringUtils.hasText(orderer)
                ? orders.orderer.contains(orderer)
                : null;
    }

    public static BooleanExpression equalStatus(OrderStatus orderStatus){
        return orderStatus == null
                ? null
                : orders.status.eq(orderStatus);
    }

    public static BooleanExpression containsAddress(String address){
        return StringUtils.hasText(address)
                ? orders.address.contains(address)
                : null;
    }
}

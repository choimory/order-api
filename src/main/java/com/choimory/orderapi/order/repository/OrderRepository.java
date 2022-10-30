package com.choimory.orderapi.order.repository;

import com.choimory.orderapi.order.entity.Order;
import com.choimory.orderapi.order.repository.querydsl.QOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, QOrderRepository {
}

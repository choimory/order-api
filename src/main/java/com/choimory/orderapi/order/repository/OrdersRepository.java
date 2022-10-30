package com.choimory.orderapi.order.repository;

import com.choimory.orderapi.order.entity.Orders;
import com.choimory.orderapi.order.repository.querydsl.QOrdersRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>, QOrdersRepository {
}

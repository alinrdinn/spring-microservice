package com.ali.customerorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ali.customerorder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}

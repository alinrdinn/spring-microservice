package com.ali.customerorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ali.customerorder.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

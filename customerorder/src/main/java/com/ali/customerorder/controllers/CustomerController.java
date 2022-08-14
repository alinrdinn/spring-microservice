package com.ali.customerorder.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.customerorder.DTO.CustomerDTO;
import com.ali.customerorder.entities.Customer;
import com.ali.customerorder.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        return ResponseEntity.ok().body(customerService.createCustomer(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().body(customerService.getCustomer(id));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().body(customerService.removeCustomer(id));
    }


}

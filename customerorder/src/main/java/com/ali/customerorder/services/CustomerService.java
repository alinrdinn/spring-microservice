package com.ali.customerorder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ali.customerorder.entities.Customer;
import com.ali.customerorder.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer reqCustomer) {
        return customerRepository.save(reqCustomer);
    }

    public Customer getCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer removeCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
            return optionalCustomer.get();
        }
        return null;
    }

}

package com.ali.customerorder.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ali.customerorder.DTO.TransactionDTO;
import com.ali.customerorder.entities.Customer;
import com.ali.customerorder.entities.Order;
import com.ali.customerorder.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final RestTemplate restTemplate;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(Integer id) {
        return orderRepository.getReferenceById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order removeOrder(Integer id) {
        Order order = orderRepository.getReferenceById(id);
        orderRepository.delete(order);
        return order;
    }

    public TransactionDTO addOrderToCustomer(Integer orderId, Integer customerId) throws JsonProcessingException {
        Customer customer = customerService.getCustomer(customerId);
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setCustomer(customer);
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> bodyParamMap = new HashMap<>();

            bodyParamMap.put("customerId", customer.getId().toString());
            bodyParamMap.put("orderId", order.getId().toString());

            String reqBodyData = new ObjectMapper().writeValueAsString(bodyParamMap);
            HttpEntity<String> requestEnty = new HttpEntity<>(reqBodyData, header);

            ResponseEntity<TransactionDTO> transactionDTO = restTemplate.postForEntity(
                "http://TRANSACTIONLOG/transaction", requestEnty, TransactionDTO.class );
            
            return transactionDTO.getBody();
        }
        
        return null;
    }
    
}

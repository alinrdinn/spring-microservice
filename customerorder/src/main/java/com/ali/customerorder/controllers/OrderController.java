package com.ali.customerorder.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ali.customerorder.DTO.OrderDTO;
import com.ali.customerorder.DTO.TransactionDTO;
import com.ali.customerorder.entities.Order;
import com.ali.customerorder.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.convertValue(orderDTO, Order.class);
        return ResponseEntity.ok().body( orderService.createOrder(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @DeleteMapping("/orders/{id}")
    public  ResponseEntity<Order> removeOrder(@PathVariable Integer id) {
        return ResponseEntity.ok().body(orderService.removeOrder(id));
    }

    @PostMapping("orders/{orderId}/addto/customer/{customerId}")
    public ResponseEntity<TransactionDTO> addToCustomer(@PathVariable(name = "orderId") Integer orderId,
        @PathVariable(name = "customerId") Integer customerId) throws JsonProcessingException {
            TransactionDTO transactionDTO = orderService.addOrderToCustomer(orderId, customerId);
            return ResponseEntity.ok().body(transactionDTO);
        }
    
}

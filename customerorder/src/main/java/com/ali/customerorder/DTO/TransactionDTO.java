package com.ali.customerorder.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDTO {
    Integer id;
    Integer customerId;
    Integer orderId;
    LocalDateTime createdAt;
}

package ali.com.transactionlog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ali.com.transactionlog.DTO.CustomerOrderDTO;
import ali.com.transactionlog.entities.Transaction;
import ali.com.transactionlog.services.TransactionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> transactionCreation(@RequestBody CustomerOrderDTO customerOrderDTO) {
        return ResponseEntity.ok().body(transactionService.logTransactionCreation(customerOrderDTO.getOrderId(), 
            customerOrderDTO.getCustomerId()));
    }
    
}

package ali.com.transactionlog.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import ali.com.transactionlog.entities.Transaction;
import ali.com.transactionlog.repositories.TransactionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction logTransactionCreation(Integer orderId, Integer customerId) {
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customerId);
        transaction.setOrderId(orderId);
        transaction.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);        
    }
    
}

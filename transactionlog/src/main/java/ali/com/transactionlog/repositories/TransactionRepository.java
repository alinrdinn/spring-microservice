package ali.com.transactionlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ali.com.transactionlog.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {}

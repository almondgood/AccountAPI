package com.example.account.repository;

import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 인터페이스로 생성, JpaRepository 상속
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByTransactionId(String transactionId);
}

package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Transaction;
import com.banking.demowebflux.core.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public Mono<Transaction> findTransactionById(Long id) {

        return transactionRepo.findById(id);
    }

    public Flux<Transaction> findTransactionByAccountId(Long accountId) {

        return transactionRepo.findByAccountId(accountId);
    }
}

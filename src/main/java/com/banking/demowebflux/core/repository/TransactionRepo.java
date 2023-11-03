package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepo extends ReactiveCrudRepository<Transaction, Long> {
    Flux<Transaction> findByAccountId(Long accountId);
}

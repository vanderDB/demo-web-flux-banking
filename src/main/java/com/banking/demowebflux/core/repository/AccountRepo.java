package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountRepo extends ReactiveCrudRepository<Account, Long> {

    Flux<Account> findByClientId(Long clientId);
}

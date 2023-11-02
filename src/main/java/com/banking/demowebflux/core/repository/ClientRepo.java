package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends ReactiveCrudRepository<Client, Long> {
}

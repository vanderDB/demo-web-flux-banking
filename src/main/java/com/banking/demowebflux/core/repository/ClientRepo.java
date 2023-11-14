package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepo extends ReactiveCrudRepository<Client, Long> {

    Flux<Client> findAllBy(Pageable pageable);
}

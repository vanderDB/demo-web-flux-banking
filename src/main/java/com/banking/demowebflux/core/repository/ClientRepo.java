package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepo extends ReactiveSortingRepository<Client, Long> {

    Flux<Client> findAllBy(Pageable pageable);
}

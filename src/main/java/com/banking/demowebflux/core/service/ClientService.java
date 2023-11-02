package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Account;
import com.banking.demowebflux.core.domain.sql.Client;
import com.banking.demowebflux.core.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private ClientRepo userRepo;

    public Mono<Client> findClientById(Long id) {

        return userRepo.findById(id);
    }
}

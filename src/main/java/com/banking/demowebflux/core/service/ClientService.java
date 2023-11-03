package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Client;
import com.banking.demowebflux.core.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private ClientRepo userRepo;
    @Autowired
    private AccountService accountService;

    public Mono<Client> findClientById(Long clientId) {

        return userRepo.findById(clientId)
                .zipWith(accountService.findAccountsByClientId(clientId).collectList())
                .map(result -> {
                    Client client = result.getT1();
                    var accounts = result.getT2();
                    client.setAccounts(accounts);
                    return client;
                });
    }
}

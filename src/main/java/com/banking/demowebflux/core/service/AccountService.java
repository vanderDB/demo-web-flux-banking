package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Account;
import com.banking.demowebflux.core.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;
    @Lazy
    @Autowired
    private ClientService clientService;

    public Mono<Account> findAccountById(Long id) {

        return accountRepo.findById(id)
                .flatMap(account -> {
                    if (account.getClientId() != null) {
                        return clientService.findClientById(account.getClientId())
                                .doOnNext(account::setClient)
                                .thenReturn(account);
                    } else {
                        return Mono.just(account);
                    }
                });
    }

    public Flux<Account> findAccountsByClientId(Long clientId) {

        return accountRepo.findByClientId(clientId);
    }
}

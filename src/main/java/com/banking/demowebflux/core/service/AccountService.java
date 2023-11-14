package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Account;
import com.banking.demowebflux.core.domain.sql.Transaction;
import com.banking.demowebflux.core.exception.ElementNotFoundException;
import com.banking.demowebflux.core.repository.AccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;
    @Lazy
    @Autowired
    private ClientService clientService;
    @Autowired
    private TransactionService transactionService;

    public Mono<Account> findAccountById(Long accountId) {

        return accountRepo.findById(accountId)
                .flatMap(account -> {
                    if (account.getClientId() != null) {
                        return clientService.findClientById(account.getClientId())
                                .doOnNext(account::setClient)
                                .thenReturn(account);
                    } else {
                        return Mono.just(account);
                    }
                })
                .switchIfEmpty(Mono.error(new ElementNotFoundException("Account not found for ID: " + accountId)));
    }

    public Flux<Account> findAccountsByClientId(Long clientId) {

        return accountRepo.findByClientId(clientId);
    }

    public Flux<Transaction> findAccountTransactions(Long accountId) {

        return findAccountById(accountId)
                .flatMapMany(account -> transactionService.findTransactionByAccountId(account.getId()))
                .switchIfEmpty(Mono.error(new ElementNotFoundException("Transactions not found for account ID: " + accountId)));
    }

    //webflux
    //posgres
    //r2dbc
    //redis для кэша
    //jwttoketn
    //java 17
    //spring boot 3
}

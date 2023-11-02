package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Account;
import com.banking.demowebflux.core.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Mono<Account> findAccountById(Long id) {
        return accountRepo.findById(id);
    }
}

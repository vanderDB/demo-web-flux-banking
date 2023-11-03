package com.banking.demowebflux.web.controller;

import com.banking.demowebflux.core.domain.sql.Transaction;
import com.banking.demowebflux.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountTransactionController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}/transactions")
    public Mono<ResponseEntity<Flux<Transaction>>> findAccountTransaction(@PathVariable Long accountId) {

        Flux<Transaction> transactions = accountService.findAccountTransactions(accountId);

        return transactions.collectList().flatMap(transactionList -> {
            if (transactionList.isEmpty()) {
                return Mono.just(ResponseEntity.notFound().build());
            } else {
                return Mono.just(ResponseEntity.ok(Flux.fromIterable(transactionList)));
            }
        });
    }
}

package com.banking.demowebflux.utils;

import org.reactivestreams.Publisher;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.test.StepVerifier;

public class TrxStepVerifier {

    private final ReactiveTransactionManager reactiveTransactionManager;

    public TrxStepVerifier(ReactiveTransactionManager transactionManager) {
        this.reactiveTransactionManager = transactionManager;
    }

    public <T> StepVerifier.FirstStep<T> create(Publisher<? extends T> publisher) {
        return StepVerifier.create(
                TransactionalOperator.create(reactiveTransactionManager)
                        .execute(trx -> {
                            trx.setRollbackOnly();
                            return publisher;
                        })
        );
    }
}

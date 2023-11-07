package com.banking.demowebflux.configuration;

import com.banking.demowebflux.utils.TrxStepVerifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.ReactiveTransactionManager;

@TestConfiguration
public class R2dbcConfiguration {

    @Bean
    public TrxStepVerifier trxStepVerifier(ReactiveTransactionManager transactionManager) {
        return new TrxStepVerifier(transactionManager);
    }
}

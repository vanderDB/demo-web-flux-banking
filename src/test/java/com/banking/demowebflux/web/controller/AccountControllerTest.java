package com.banking.demowebflux.web.controller;

import com.banking.demowebflux.configuration.AbstractWebIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class AccountControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void whenFetchAccountById_thenSpecificAccountExpected() {

        long expectedAccountId = 1;
        String expectedAccountType = "Savings";
        long expectedAccountNumber = 123456;
        float expectedBalance = 1000.00f;
        String expectedStatus = "Active";

        webClient.get()
                .uri("/api/v1/accounts/{id}", expectedAccountId)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.accountType").isEqualTo(expectedAccountType)
                .jsonPath("$.accountNumber").isEqualTo(expectedAccountNumber)
                .jsonPath("$.balance").isEqualTo(expectedBalance)
                .jsonPath("$.status").isEqualTo(expectedStatus);
    }
}

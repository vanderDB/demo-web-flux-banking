package com.banking.demowebflux.core.service;

import com.banking.demowebflux.configuration.AbstractServiceIntegrationTest;
import com.banking.demowebflux.web.bean.CreateClientBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest extends AbstractServiceIntegrationTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void whenAddClient_thenNewOneIsExpected() {

        String firstName = "Petrov";
        String lastName = "Ilia";
        String email = "test22-ilia@gmail.com";

        var createClientBean = new CreateClientBean(firstName, lastName, email);
        clientService.addClient(createClientBean)
                .as(trxStepVerifier::create)
                .expectNextMatches(client ->
                        client.getFirstName().equals(firstName) &&
                                client.getLastName().equals(lastName) &&
                                client.getEmail().equals(email)
                )
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    public void whenFindAllClients_thenActualCountAndInitialPageExpected() {

        Pageable pageable = PageRequest.of(0, 10);
        int expectedClientsCount = 3;

        trxStepVerifier.create(clientService.findAllClients(pageable))
                .expectNextMatches(page -> {
                    assertEquals(expectedClientsCount, page.getTotalElements());
                    assertEquals(pageable, page.getPageable());
                    return true;
                })
                .verifyComplete();
    }

    @Test
    public void whenFindExistedClientById_thenSpecificClientExpected() {

        long expectedClientId = 1;
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john@example.com";
        long expectedAccountsCount = 2;

        trxStepVerifier.create(clientService.findClientById(expectedClientId))
                .expectNextMatches(client -> {
                    assertEquals(expectedClientId, client.getId());
                    assertEquals(expectedEmail, client.getEmail());
                    assertEquals(expectedFirstName, client.getFirstName());
                    assertEquals(expectedLastName, client.getLastName());
                    assertEquals(expectedAccountsCount, client.getAccounts().size());

                    return true;
                })
                .verifyComplete();
    }
}

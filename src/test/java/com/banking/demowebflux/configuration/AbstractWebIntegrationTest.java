package com.banking.demowebflux.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class AbstractWebIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected WebTestClient webClient;
}

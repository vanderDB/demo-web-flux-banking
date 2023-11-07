package com.banking.demowebflux.configuration;

import com.banking.demowebflux.utils.TrxStepVerifier;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected TrxStepVerifier trxStepVerifier;
}

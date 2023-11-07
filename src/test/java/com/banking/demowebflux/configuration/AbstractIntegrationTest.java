package com.banking.demowebflux.configuration;

import com.banking.demowebflux.utils.TrxStepVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(R2dbcConfiguration.class)
public class AbstractIntegrationTest {

    @Autowired
    protected TrxStepVerifier trxStepVerifier;

    //    @Test
//    public void whenDeleteAll_then0IsExpected() {
//        clientRepo.deleteAll()
//                .as(trxStepVerifier::create)
//                .expectNextCount(0)
//                .verifyComplete();
//    }

//    @Test
//    public void whenInsert6_then6AreExpected() {
//        clientRepo.findAll()
//                .as(trxStepVerifier::create)
//                .expectNextCount(3)
//                .verifyComplete();
//    }
}

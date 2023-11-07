package com.banking.demowebflux.configuration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Import(R2dbcConfiguration.class)
public class AbstractIntegrationTest {


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

package com.banking.demowebflux.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/{userId}")
    public Mono<String> findUserById(@PathVariable Long userId) {

        return Mono.just("Test user");
    }
}

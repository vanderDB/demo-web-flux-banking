package com.banking.demowebflux.web.controller;

import com.banking.demowebflux.core.domain.sql.Client;
import com.banking.demowebflux.core.service.ClientService;
import com.banking.demowebflux.web.bean.CreateClientBean;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Mono<ResponseEntity<Client>> findClientById(@PathVariable Long clientId) {
        return clientService.findClientById(clientId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound()
                        .build());
    }

    @PostMapping
    public Mono<ResponseEntity<Client>> addClient(@Valid @RequestBody CreateClientBean client) {
        return clientService.addClient(client)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/find-all")
    public Mono<ResponseEntity<Page<Client>>> findAllClients(Pageable pageable) {

        return clientService.findAllClients(pageable)
                .flatMap(clientsPage -> Mono.just(ResponseEntity.ok(clientsPage)));
    }
}

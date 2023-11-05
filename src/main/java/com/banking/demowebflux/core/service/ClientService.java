package com.banking.demowebflux.core.service;

import com.banking.demowebflux.core.domain.sql.Client;
import com.banking.demowebflux.core.repository.ClientRepo;
import com.banking.demowebflux.web.bean.CreateClientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private AccountService accountService;

    public Mono<Client> findClientById(Long clientId) {

        return clientRepo.findById(clientId)
                .zipWith(accountService.findAccountsByClientId(clientId).collectList())
                .map(result -> {
                    Client client = result.getT1();
                    var accounts = result.getT2();
                    client.setAccounts(accounts);
                    return client;
                });
    }

    public Mono<Client> addClient(CreateClientBean createClientBean) {

        var client = new Client(createClientBean);

        return clientRepo.save(client);
    }

    public Mono<Page<Client>> findAllClients(Pageable pageable) {
        return clientRepo.findAllBy(pageable)
                .collectList()
                .zipWith(clientRepo.count())
                .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2()));
    }
}

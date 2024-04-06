package com.artemnizhnyk.eventhandler.service.client;

import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.repository.ClientRepository;
import com.artemnizhnyk.eventhandler.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final AccountService accountService;

    @Override
    public Client create(final Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }
}

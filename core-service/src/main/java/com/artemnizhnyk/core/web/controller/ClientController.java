package com.artemnizhnyk.core.web.controller;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.client.ClientService;
import com.artemnizhnyk.core.web.dto.AccountDto;
import com.artemnizhnyk.core.web.dto.CardDto;
import com.artemnizhnyk.core.web.dto.ClientDto;
import com.artemnizhnyk.core.web.dto.mapper.AccountMapper;
import com.artemnizhnyk.core.web.dto.mapper.CardMapper;
import com.artemnizhnyk.core.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
@RestController
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @PreAuthorize("@ssi.canAccessClient(#id)")
    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @PreAuthorize("@ssi.canAccessClient(#id)")
    @GetMapping("/{id}/cards")
    public List<CardDto> getCardsById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @PreAuthorize("@ssi.canAccessClient(#id)")
    @GetMapping("/{id}/account")
    public AccountDto getAccountById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }
}

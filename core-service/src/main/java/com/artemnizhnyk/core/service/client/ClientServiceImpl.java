package com.artemnizhnyk.core.service.client;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.service.client.ClientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;

    @Override
    public void create(final Client object) {
        commandService.create(object);
    }

    @Override
    public Client getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return queryService.existsByUsername(username);
    }

    @Override
    public Client getByUsername(final String username) {
        return queryService.getByUsername(username);
    }
}

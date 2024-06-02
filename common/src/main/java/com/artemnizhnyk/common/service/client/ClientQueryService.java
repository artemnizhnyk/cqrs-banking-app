package com.artemnizhnyk.common.service.client;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.service.QueryService;

import java.util.UUID;


public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(final String username);

    Client getByUsername(final String username);

    Client getByAccount(final UUID accountId);
}

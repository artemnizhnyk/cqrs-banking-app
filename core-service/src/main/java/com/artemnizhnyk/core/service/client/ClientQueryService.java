package com.artemnizhnyk.core.service.client;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(final String username);

    Client getByUsername(final String username);
}

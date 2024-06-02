package com.artemnizhnyk.core.service.client;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.CommandService;
import com.artemnizhnyk.common.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {

    boolean existsByUsername(final String username);

    Client getByUsername(final String username);

}

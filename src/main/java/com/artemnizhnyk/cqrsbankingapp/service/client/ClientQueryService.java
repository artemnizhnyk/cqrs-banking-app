package com.artemnizhnyk.cqrsbankingapp.service.client;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(final String username);

    Client getByUsername(final String username);
}

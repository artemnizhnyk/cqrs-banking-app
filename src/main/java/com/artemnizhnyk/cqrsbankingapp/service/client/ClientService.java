package com.artemnizhnyk.cqrsbankingapp.service.client;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.service.CommandService;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {
}

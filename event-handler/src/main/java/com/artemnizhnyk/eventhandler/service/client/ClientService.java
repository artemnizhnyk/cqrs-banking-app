package com.artemnizhnyk.eventhandler.service.client;

import com.artemnizhnyk.common.domain.model.Client;

import java.util.UUID;

public interface ClientService {

    Client create(final Client client);

    void addCard(final UUID clientId, final UUID cardId);
}

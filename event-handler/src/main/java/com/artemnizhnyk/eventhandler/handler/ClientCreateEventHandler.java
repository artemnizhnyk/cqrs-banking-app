package com.artemnizhnyk.eventhandler.handler;

import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.events.CardCreateEvent;
import com.artemnizhnyk.common.events.ClientCreateEvent;
import com.artemnizhnyk.eventhandler.service.client.ClientService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("CLIENT_CREATE")
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final Gson gson;

    @Transactional
    @Override
    public void handle(final JsonObject object, final Acknowledgment acknowledgment) {
        ClientCreateEvent event = gson.fromJson(object, ClientCreateEvent.class);
        Client client = gson.fromJson((String) event.getPayload(), Client.class);
        clientService.create(client);
        acknowledgment.acknowledge();
    }
}

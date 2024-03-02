package com.artemnizhnyk.cqrsbankingapp.service.client;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.events.ClientCreateEvent;
import com.artemnizhnyk.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(final Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }
}

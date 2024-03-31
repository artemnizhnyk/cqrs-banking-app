package com.artemnizhnyk.core.service.client;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.events.ClientCreateEvent;
import com.artemnizhnyk.core.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
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

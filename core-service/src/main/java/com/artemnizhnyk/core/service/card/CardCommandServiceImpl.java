package com.artemnizhnyk.core.service.card;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.events.CardCreateEvent;
import com.artemnizhnyk.core.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(final Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }
}

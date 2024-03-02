package com.artemnizhnyk.cqrsbankingapp.service.card;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.events.CardCreateEvent;
import com.artemnizhnyk.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

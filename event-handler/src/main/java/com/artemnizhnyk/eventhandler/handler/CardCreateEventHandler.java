package com.artemnizhnyk.eventhandler.handler;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.events.CardCreateEvent;
import com.artemnizhnyk.eventhandler.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("CARD_CREATE")
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Transactional
    @Override
    public void handle(final JsonObject object, final Acknowledgment acknowledgment) {
        CardCreateEvent event = gson.fromJson(object, CardCreateEvent.class);
        Card card = gson.fromJson((String) event.getPayload(), Card.class);
        cardService.create(card);
        acknowledgment.acknowledge();
    }
}

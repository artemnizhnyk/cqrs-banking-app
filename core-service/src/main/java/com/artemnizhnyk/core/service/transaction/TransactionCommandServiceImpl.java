package com.artemnizhnyk.core.service.transaction;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.events.TransactionCreateEvent;
import com.artemnizhnyk.core.service.card.CardService;
import com.artemnizhnyk.core.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;
    private final CardService cardService;

    @Override
    public void create(final Transaction object) {
        Card from = cardService.getByNumberAndDateAndCvv(
                object.getFrom().getNumber(),
                object.getFrom().getDate(),
                object.getFrom().getCvv()
        );
        Card to = cardService.getByNumberAndDate(
                object.getTo().getNumber(),
                object.getTo().getDate()
        );
        object.setFrom(from);
        object.setTo(to);
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}

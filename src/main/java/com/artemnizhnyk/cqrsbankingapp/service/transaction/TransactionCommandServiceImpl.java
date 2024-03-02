package com.artemnizhnyk.cqrsbankingapp.service.transaction;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Transaction;
import com.artemnizhnyk.cqrsbankingapp.events.TransactionCreateEvent;
import com.artemnizhnyk.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(final Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}

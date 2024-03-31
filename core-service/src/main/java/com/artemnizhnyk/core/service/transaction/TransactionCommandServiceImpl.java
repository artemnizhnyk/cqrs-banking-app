package com.artemnizhnyk.core.service.transaction;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.events.TransactionCreateEvent;
import com.artemnizhnyk.core.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
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

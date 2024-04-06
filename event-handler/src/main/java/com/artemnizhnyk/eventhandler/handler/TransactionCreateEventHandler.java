package com.artemnizhnyk.eventhandler.handler;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.events.TransactionCreateEvent;
import com.artemnizhnyk.eventhandler.service.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("TRANSACTION_CREATE")
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Transactional
    @Override
    public void handle(final JsonObject object, final Acknowledgment acknowledgment) {
        TransactionCreateEvent event = gson.fromJson(object, TransactionCreateEvent.class);
        Transaction transaction = gson.fromJson((String) event.getPayload(), Transaction.class);
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }
}

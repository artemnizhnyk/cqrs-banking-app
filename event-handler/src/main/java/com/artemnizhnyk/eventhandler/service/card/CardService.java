package com.artemnizhnyk.eventhandler.service.card;

import com.artemnizhnyk.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {

    Card getById(final UUID id);

    Card create(final Card card);

    void add(final Card card, final BigDecimal amount);

    void addTransaction(final UUID cardId, final UUID transactionId);
}

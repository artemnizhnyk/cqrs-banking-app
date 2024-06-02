package com.artemnizhnyk.core.service.card;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.core.service.CommandService;
import com.artemnizhnyk.common.service.QueryService;

import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(final UUID clientId);

    boolean existsByNumberAndDate(final String number, final String date);

    Card getByNumberAndDateAndCvv(final String number, final String date, final String cvv);

    Card getByNumberAndDate(final String number, final String date);
}

package com.artemnizhnyk.core.service.card;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.core.service.QueryService;

public interface CardQueryService extends QueryService<Card> {
    boolean existsByNumberAndDate(final String number, final String date);

    Card getByNumberAndDateAndCvv(final String number, final String date, final String cvv);
}

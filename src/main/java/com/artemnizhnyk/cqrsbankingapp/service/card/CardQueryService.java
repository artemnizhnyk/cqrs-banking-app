package com.artemnizhnyk.cqrsbankingapp.service.card;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

public interface CardQueryService extends QueryService<Card> {
    boolean existsByNumberAndDate(final String number, final String date);

    Card getByNumberAndDateAndCvv(final String number, final String date, final String cvv);
}

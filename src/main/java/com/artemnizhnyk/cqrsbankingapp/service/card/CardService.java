package com.artemnizhnyk.cqrsbankingapp.service.card;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.service.CommandService;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(final UUID clientId);
}

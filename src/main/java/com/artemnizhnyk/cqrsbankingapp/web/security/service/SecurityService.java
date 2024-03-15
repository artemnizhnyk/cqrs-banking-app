package com.artemnizhnyk.cqrsbankingapp.web.security.service;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(final UUID clientId);

    boolean canAccessCard(final UUID cardId);

    boolean canAccessCard(final Card card);

    boolean canAccessTransaction(final UUID transactionId);

}

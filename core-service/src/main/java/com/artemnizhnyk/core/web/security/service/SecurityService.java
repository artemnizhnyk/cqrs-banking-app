package com.artemnizhnyk.core.web.security.service;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.core.web.dto.CardDto;
import com.artemnizhnyk.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(final UUID clientId);

    boolean canAccessCard(final UUID cardId);

    boolean canAccessCard(final CardDto card);

    boolean canAccessTransaction(final UUID transactionId);

}

package com.artemnizhnyk.core.service.card;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;

    @Override
    public void create(final Card object) {
        commandService.create(object);
    }

    @Override
    public void createByClientId(final UUID clientId) {
        Client client = clientService.getById(clientId);
        Card card = new Card(client.getAccount());
        commandService.create(card);
    }

    @Override
    public Card getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public boolean existsByNumberAndDate(final String number, final String date) {
        return queryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(final String number, final String date, final String cvv) {
        return queryService.getByNumberAndDateAndCvv(number, date, cvv);
    }

}

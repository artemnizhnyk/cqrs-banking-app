package com.artemnizhnyk.cqrsbankingapp.service.card;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;

    @Override
    public void create(final Card object) {
        commandService.create(object);
    }

    @Override
    public Card getById(final UUID id) {
        return queryService.getById(id);
    }
}

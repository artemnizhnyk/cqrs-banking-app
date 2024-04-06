package com.artemnizhnyk.eventhandler.service.account;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Override
    public Card create(final Card card) {
        //TODO set number, date and cvv
        return repository.save(card);
    }
}

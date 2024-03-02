package com.artemnizhnyk.cqrsbankingapp.service.card;

import com.artemnizhnyk.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

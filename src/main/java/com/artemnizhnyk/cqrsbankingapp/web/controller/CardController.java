package com.artemnizhnyk.cqrsbankingapp.web.controller;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import com.artemnizhnyk.cqrsbankingapp.service.card.CardService;
import com.artemnizhnyk.cqrsbankingapp.web.dto.CardDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.TransactionDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.mapper.CardMapper;
import com.artemnizhnyk.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
@RestController
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        //TODO implement
        UUID id = UUID.randomUUID();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }
}

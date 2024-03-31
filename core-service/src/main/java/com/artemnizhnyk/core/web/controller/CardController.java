package com.artemnizhnyk.core.web.controller;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.core.service.card.CardService;
import com.artemnizhnyk.core.web.dto.CardDto;
import com.artemnizhnyk.core.web.dto.TransactionDto;
import com.artemnizhnyk.core.web.dto.mapper.CardMapper;
import com.artemnizhnyk.core.web.dto.mapper.TransactionMapper;
import com.artemnizhnyk.core.web.security.SecurityUser;
import com.artemnizhnyk.core.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
@RestController
public class CardController {

    private final CardService cardService;
    private final SecurityService securityService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @PreAuthorize("@ssi.canAccessCard(#id)")
    @GetMapping("/{id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @PreAuthorize("@ssi.canAccessCard(#id)")
    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }
}

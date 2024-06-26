package com.artemnizhnyk.core.web.controller;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.core.service.card.CardService;
import com.artemnizhnyk.core.service.transaction.TransactionService;
import com.artemnizhnyk.core.web.dto.OnCreate;
import com.artemnizhnyk.core.web.dto.TransactionDto;
import com.artemnizhnyk.core.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PreAuthorize("@ssi.canAccessCard(#dto.from)")
    @PostMapping
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto dto) {
        if (!cardService.existsByNumberAndDate(
                dto.getTo().getNumber(),
                dto.getTo().getDate()
        )) {
            throw new IllegalStateException("Card doesn't exists");
        }
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionService.create(transaction);
    }

    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }
}

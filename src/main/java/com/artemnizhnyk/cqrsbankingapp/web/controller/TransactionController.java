package com.artemnizhnyk.cqrsbankingapp.web.controller;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Transaction;
import com.artemnizhnyk.cqrsbankingapp.service.card.CardService;
import com.artemnizhnyk.cqrsbankingapp.service.transaction.TransactionService;
import com.artemnizhnyk.cqrsbankingapp.web.dto.OnCreate;
import com.artemnizhnyk.cqrsbankingapp.web.dto.TransactionDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }
}

package com.artemnizhnyk.eventhandler.service.transaction;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.repository.TransactionRepository;
import com.artemnizhnyk.eventhandler.service.card.CardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CardService cardService;

    @Override
    @Transactional
    public Transaction create(final Transaction transaction) {
        Card cardFrom = cardService.getById(transaction.getFrom().getId());
        Card cardTo = cardService.getById(transaction.getTo().getId());

        checkBalance(cardFrom, transaction.getAmount());

        cardService.add(cardFrom, transaction.getAmount().negate());
        cardService.add(cardTo, transaction.getAmount());

        repository.save(transaction);

        cardService.addTransaction(cardTo.getId(), transaction.getId());
        cardService.addTransaction(cardFrom.getId(), transaction.getId());

        return transaction;
    }

    private void checkBalance(final Card card, final BigDecimal amount) {
        if (card.getAccount().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money on card account.");
        }
    }
}

package com.artemnizhnyk.eventhandler.service.transaction;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Transaction create(final Transaction transaction) {
        //TODO change balance of card accounts
        return repository.save(transaction);
    }
}

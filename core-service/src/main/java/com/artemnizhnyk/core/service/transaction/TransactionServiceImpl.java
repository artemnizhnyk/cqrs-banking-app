package com.artemnizhnyk.core.service.transaction;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionQueryService queryService;
    private final TransactionCommandService commandService;

    @Override
    public void create(final Transaction object) {
        commandService.create(object);
    }

    @Override
    public Transaction getById(final UUID id) {
        return queryService.getById(id);
    }
}

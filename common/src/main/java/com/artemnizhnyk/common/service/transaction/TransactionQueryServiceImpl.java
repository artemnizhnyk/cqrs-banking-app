package com.artemnizhnyk.common.service.transaction;

import com.artemnizhnyk.common.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.common.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

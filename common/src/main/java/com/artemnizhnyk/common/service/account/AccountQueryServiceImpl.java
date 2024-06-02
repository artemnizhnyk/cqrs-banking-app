package com.artemnizhnyk.common.service.account;

import com.artemnizhnyk.common.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.common.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

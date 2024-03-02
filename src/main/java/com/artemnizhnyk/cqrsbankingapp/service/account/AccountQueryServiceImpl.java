package com.artemnizhnyk.cqrsbankingapp.service.account;

import com.artemnizhnyk.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import com.artemnizhnyk.cqrsbankingapp.repository.AccountRepository;
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

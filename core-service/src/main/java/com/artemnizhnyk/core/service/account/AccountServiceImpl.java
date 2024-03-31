package com.artemnizhnyk.core.service.account;

import com.artemnizhnyk.common.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;
    private final AccountCommandService commandService;

    @Override
    public void create(final Account object) {
        commandService.create(object);
    }

    @Override
    public Account getById(final UUID id) {
        return queryService.getById(id);
    }
}

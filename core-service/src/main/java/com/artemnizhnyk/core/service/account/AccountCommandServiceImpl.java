package com.artemnizhnyk.core.service.account;

import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.common.events.AccountCreateEvent;
import com.artemnizhnyk.core.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(final Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}

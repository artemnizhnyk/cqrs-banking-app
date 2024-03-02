package com.artemnizhnyk.cqrsbankingapp.service.account;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import com.artemnizhnyk.cqrsbankingapp.events.AccountCreateEvent;
import com.artemnizhnyk.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

package com.artemnizhnyk.cqrsbankingapp.service.event;

import com.artemnizhnyk.cqrsbankingapp.events.AbstractEvent;
import com.artemnizhnyk.cqrsbankingapp.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(final AbstractEvent event) {
        repository.save(event);
    }
}

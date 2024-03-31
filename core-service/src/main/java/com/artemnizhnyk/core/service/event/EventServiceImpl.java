package com.artemnizhnyk.core.service.event;

import com.artemnizhnyk.common.events.AbstractEvent;
import com.artemnizhnyk.common.repository.EventRepository;
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

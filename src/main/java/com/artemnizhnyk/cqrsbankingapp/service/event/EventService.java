package com.artemnizhnyk.cqrsbankingapp.service.event;

import com.artemnizhnyk.cqrsbankingapp.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}

package com.artemnizhnyk.core.service.event;

import com.artemnizhnyk.common.events.AbstractEvent;

public interface EventService {

    void create(final AbstractEvent event);
}

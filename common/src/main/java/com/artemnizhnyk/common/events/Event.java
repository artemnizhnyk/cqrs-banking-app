package com.artemnizhnyk.common.events;

import com.artemnizhnyk.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(final Aggregate aggregate);
}

package com.artemnizhnyk.cqrsbankingapp.events;

import com.artemnizhnyk.cqrsbankingapp.domain.aggregate.Aggregate;

public interface Event {

    void apply(final Aggregate aggregate);
}

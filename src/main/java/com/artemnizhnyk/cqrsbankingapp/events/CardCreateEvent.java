package com.artemnizhnyk.cqrsbankingapp.events;

import com.artemnizhnyk.cqrsbankingapp.domain.aggregate.Aggregate;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(Object payload) {
        super(null, EventType.CARD_CRATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

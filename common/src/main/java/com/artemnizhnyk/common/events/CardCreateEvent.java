package com.artemnizhnyk.common.events;

import com.artemnizhnyk.common.domain.aggregate.Aggregate;
import com.artemnizhnyk.common.domain.model.Card;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(Card payload) {
        super(null, EventType.CARD_CRATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

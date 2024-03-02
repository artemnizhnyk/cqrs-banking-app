package com.artemnizhnyk.cqrsbankingapp.events;

import com.artemnizhnyk.cqrsbankingapp.domain.aggregate.Aggregate;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
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

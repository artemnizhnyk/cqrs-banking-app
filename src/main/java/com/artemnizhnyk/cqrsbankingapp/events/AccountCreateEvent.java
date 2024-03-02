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
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent(Object payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

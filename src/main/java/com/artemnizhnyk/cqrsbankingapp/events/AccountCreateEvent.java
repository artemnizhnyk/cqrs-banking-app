package com.artemnizhnyk.cqrsbankingapp.events;

import com.artemnizhnyk.cqrsbankingapp.domain.aggregate.Aggregate;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent(Account payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

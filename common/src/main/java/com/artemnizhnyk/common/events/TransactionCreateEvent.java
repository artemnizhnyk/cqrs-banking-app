package com.artemnizhnyk.common.events;

import com.artemnizhnyk.common.domain.aggregate.Aggregate;
import com.artemnizhnyk.common.domain.model.Transaction;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(Transaction payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

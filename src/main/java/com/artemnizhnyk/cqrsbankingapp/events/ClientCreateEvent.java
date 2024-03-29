package com.artemnizhnyk.cqrsbankingapp.events;

import com.artemnizhnyk.cqrsbankingapp.domain.aggregate.Aggregate;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}

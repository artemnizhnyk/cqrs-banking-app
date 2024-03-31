package com.artemnizhnyk.common.events;

import com.artemnizhnyk.common.domain.model.ObjectConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "events")
@Entity
public abstract class AbstractEvent implements Event {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID aggregateId;
    @Enumerated(EnumType.STRING)
    private EventType type;
    @CreationTimestamp
    private LocalDateTime timestamp;
    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = ObjectConverter.class)
    private Object payload;

    public AbstractEvent(final UUID aggregateId, final EventType type, final Object payload) {
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }
}

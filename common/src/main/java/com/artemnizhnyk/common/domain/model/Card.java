package com.artemnizhnyk.common.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "cards")
@Entity
public class Card {

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue
    @Id
    private UUID id;
    private String number;
    private String date;
    private String cvv;
    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;
    @ManyToOne
    private Account account;

    public Card(final Account account) {
        this.account = account;
    }
}

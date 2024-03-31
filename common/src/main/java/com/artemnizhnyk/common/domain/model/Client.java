package com.artemnizhnyk.common.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Table(name = "clients")
@Entity
public class Client {

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue
    @Id
    private UUID id;
    private String name;
    private String username;
    private String password;
    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;
    @OneToOne
    private Account account;
}

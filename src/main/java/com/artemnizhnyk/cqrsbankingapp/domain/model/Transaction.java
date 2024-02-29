package com.artemnizhnyk.cqrsbankingapp.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Table(name= "transactions")
@Entity
public class Transaction {

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue
    @Id
    private UUID id;
    @ManyToOne
    private Card from;
    @ManyToOne
    private Card to;
    private BigDecimal amount;
}

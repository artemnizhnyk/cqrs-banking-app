package com.artemnizhnyk.common.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Table(name = "accounts")
@Entity
public class Account {

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue
    @Id
    private UUID id;
    private String number;
    private BigDecimal balance;
}

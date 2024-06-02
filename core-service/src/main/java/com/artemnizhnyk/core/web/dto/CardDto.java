package com.artemnizhnyk.core.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CardDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    @Null(message = "Id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "Number must be not null",
            groups = {OnCreate.class, OnTransactionFrom.class, OnTransactionTo.class})
    private String number;

    @NotNull(message = "Date must be not null", groups = {OnCreate.class, OnTransactionFrom.class})
    private String date;

    @NotNull(message = "cvv must be not null", groups = {OnCreate.class, OnTransactionFrom.class})
    @Null(message = "cvv must be null", groups = OnTransactionTo.class)
    private String cvv;
}

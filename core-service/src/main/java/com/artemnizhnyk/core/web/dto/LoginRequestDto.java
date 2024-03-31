package com.artemnizhnyk.core.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {

    @NotNull(message = "Username must be not null")
    private String username;
    @NotNull(message = "Password must be not null")
    private String password;
}

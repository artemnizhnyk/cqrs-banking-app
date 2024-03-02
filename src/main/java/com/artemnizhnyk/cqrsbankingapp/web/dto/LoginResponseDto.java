package com.artemnizhnyk.cqrsbankingapp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {

    private String access;
    private String refresh;
}

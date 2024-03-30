package com.artemnizhnyk.cqrsbankingapp.web.controller;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.service.auth.AuthService;
import com.artemnizhnyk.cqrsbankingapp.web.dto.ClientDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginRequestDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginResponseDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.OnCreate;
import com.artemnizhnyk.cqrsbankingapp.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto dto) {
        Client client = clientMapper.toEntity(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Validated final LoginRequestDto dto) {
        return authService.login(dto);
    }

}

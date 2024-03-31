package com.artemnizhnyk.core.web.controller;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.auth.AuthService;
import com.artemnizhnyk.core.web.dto.ClientDto;
import com.artemnizhnyk.core.web.dto.LoginRequestDto;
import com.artemnizhnyk.core.web.dto.LoginResponseDto;
import com.artemnizhnyk.core.web.dto.OnCreate;
import com.artemnizhnyk.core.web.dto.mapper.ClientMapper;
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

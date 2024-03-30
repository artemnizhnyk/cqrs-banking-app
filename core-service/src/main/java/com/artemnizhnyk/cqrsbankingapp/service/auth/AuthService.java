package com.artemnizhnyk.cqrsbankingapp.service.auth;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginRequestDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(final LoginRequestDto request);

    void register(final Client client);
}

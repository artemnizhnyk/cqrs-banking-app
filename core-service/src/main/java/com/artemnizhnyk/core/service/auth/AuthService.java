package com.artemnizhnyk.core.service.auth;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.web.dto.LoginRequestDto;
import com.artemnizhnyk.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(final LoginRequestDto request);

    void register(final Client client);
}

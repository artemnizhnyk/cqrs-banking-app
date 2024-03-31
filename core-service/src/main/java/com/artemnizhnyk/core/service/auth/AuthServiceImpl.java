package com.artemnizhnyk.core.service.auth;

import com.artemnizhnyk.common.domain.exception.ResourceAlreadyExistsException;
import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.client.ClientService;
import com.artemnizhnyk.core.web.dto.LoginRequestDto;
import com.artemnizhnyk.core.web.dto.LoginResponseDto;
import com.artemnizhnyk.core.web.security.jwt.JwtProperties;
import com.artemnizhnyk.core.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(
                tokenService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                )
        );
        response.setRefresh(
                tokenService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.REFRESH.name(),
                                        jwtProperties.getRefresh()
                                )
                                .build()
                )
        );
        return response;
    }

    @Override
    public void register(final Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }
}

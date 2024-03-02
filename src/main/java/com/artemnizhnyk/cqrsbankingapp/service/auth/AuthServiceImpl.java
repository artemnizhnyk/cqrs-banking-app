package com.artemnizhnyk.cqrsbankingapp.service.auth;

import com.artemnizhnyk.cqrsbankingapp.domain.exception.ResourceAlreadyExistsException;
import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.service.client.ClientService;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginRequestDto;
import com.artemnizhnyk.cqrsbankingapp.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        //TODO implement
        return null;
    }

    @Override
    public void register(final Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        //TODO hash password
        client.setPassword(client.getPassword());
        clientService.create(client);
    }
}

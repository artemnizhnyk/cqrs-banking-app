package com.artemnizhnyk.core.web.security;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityUserService implements UserDetailsService {

    private final ClientService clientService;

    @Override
    public SecurityUser loadUserByUsername(
            final String username
    ) {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }

}

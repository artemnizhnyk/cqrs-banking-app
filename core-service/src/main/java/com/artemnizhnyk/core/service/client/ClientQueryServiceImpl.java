package com.artemnizhnyk.core.service.client;

import com.artemnizhnyk.common.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.common.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository repository;

    @Override
    public Client getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Client getByUsername(final String username) {
        return repository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

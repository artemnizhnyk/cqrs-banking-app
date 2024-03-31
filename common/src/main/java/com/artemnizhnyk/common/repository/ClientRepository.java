package com.artemnizhnyk.common.repository;

import com.artemnizhnyk.common.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByUsername(final String username);

    Optional<Client> findByUsername(final String username);
}

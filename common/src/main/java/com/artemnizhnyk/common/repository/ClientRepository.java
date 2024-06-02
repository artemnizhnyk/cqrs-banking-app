package com.artemnizhnyk.common.repository;

import com.artemnizhnyk.common.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByUsername(final String username);

    Optional<Client> findByUsername(final String username);

    Optional<Client> findByAccountId(UUID accountId);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO clients_cards
            VALUES (:clientId, :cardId)
            """, nativeQuery = true
    )
    void addCard(@Param("clientId") String clientId, @Param("cardId") String cardId);
}

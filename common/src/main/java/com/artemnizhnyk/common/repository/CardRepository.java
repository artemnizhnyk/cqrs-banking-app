package com.artemnizhnyk.common.repository;

import com.artemnizhnyk.common.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    boolean existsByNumberAndDate(final String number, final String date);

    Optional<Card> findByDateAndNumberAndCvv(final String number, final String date, final String cvv);
}

package com.artemnizhnyk.cqrsbankingapp.repository;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
    boolean existsByNumberAndDate(final String number, final String date);
}

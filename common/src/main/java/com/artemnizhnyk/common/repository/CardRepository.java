package com.artemnizhnyk.common.repository;

import com.artemnizhnyk.common.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    boolean existsByNumberAndDate(final String number, final String date);

    Optional<Card> findByDateAndNumberAndCvv(final String number, final String date, final String cvv);

    Optional<Card> findByNumberAndDate(final String number, final String date);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO cards_transactions
            VALUES (:cardId, :transactionId)
            """, nativeQuery = true)
    void addTransaction(@Param("cardId") String cardId, @Param("transactionId") String transactionId);

}

package com.artemnizhnyk.cqrsbankingapp.repository;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}

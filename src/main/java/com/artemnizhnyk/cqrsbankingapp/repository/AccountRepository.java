package com.artemnizhnyk.cqrsbankingapp.repository;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}

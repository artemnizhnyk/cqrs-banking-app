package com.artemnizhnyk.cqrsbankingapp.repository;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import com.artemnizhnyk.cqrsbankingapp.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, Long> {
}

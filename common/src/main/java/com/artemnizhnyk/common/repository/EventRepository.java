package com.artemnizhnyk.common.repository;

import com.artemnizhnyk.common.events.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}

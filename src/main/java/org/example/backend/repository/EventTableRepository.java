package org.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.backend.model.EventTable;

@Repository
public interface EventTableRepository extends JpaRepository<EventTable, Integer> {
}

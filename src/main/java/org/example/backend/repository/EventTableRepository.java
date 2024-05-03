package org.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.backend.model.EventTable;

import java.util.List;
import java.util.Set;

@Repository
public interface EventTableRepository extends JpaRepository<EventTable, Integer> {
}

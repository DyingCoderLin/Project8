package org.example.backend.repository;

import org.example.backend.model.TimeConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TimeConnectionRepository extends JpaRepository<TimeConnection, Integer> {
}

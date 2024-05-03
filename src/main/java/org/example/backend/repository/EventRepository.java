package org.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.backend.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{

}

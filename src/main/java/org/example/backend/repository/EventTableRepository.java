package org.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.backend.model.EventTable;

import java.util.List;


@Repository
public interface EventTableRepository extends JpaRepository<EventTable, Integer> {
    void deleteByTableID(Integer tableID);
    EventTable getByTableID(Integer tableID);
    List<EventTable> findByTableNameContaining(String tableName);
    long count();
}

package org.example.backend.repository;

import jakarta.transaction.Transactional;
import org.example.backend.model.CourseTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTimeTableRepository extends JpaRepository<CourseTimeTable, Integer> {
    public CourseTimeTable findByEventTableID(Integer eventTableID);
    public void deleteByEventTableID(Integer eventTableID);
}

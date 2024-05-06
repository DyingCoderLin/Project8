package org.example.backend.service;

import org.example.backend.model.CourseTimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.CourseTimeTableRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseTimeTableService {
    private final CourseTimeTableRepository courseTimeTableRepository;

    @Autowired
    public CourseTimeTableService(CourseTimeTableRepository courseTimeTableRepository) {
        this.courseTimeTableRepository = courseTimeTableRepository;
    }

    public CourseTimeTable findByEventTableID(Integer eventTableID) {
        return courseTimeTableRepository.findByEventTableID(eventTableID);
    }

    public void save(CourseTimeTable courseTimeTable) {
        courseTimeTableRepository.save(courseTimeTable);
    }

    public void deleteByEventTableID(Integer eventTableID) {
        courseTimeTableRepository.deleteByEventTableID(eventTableID);
    }
}

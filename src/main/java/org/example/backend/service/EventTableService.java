package org.example.backend.service;

import org.example.backend.model.User;
import org.example.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.EventTableRepository;
import org.example.backend.model.EventTable;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
@Transactional
public class EventTableService {

    private final EventTableRepository eventTableRepository;
    private final CourseTimeTableRepository courseTimeTableRepository;

    @Autowired
    public EventTableService(EventTableRepository eventTableRepository, CourseTimeTableRepository courseTimeTableRepository) {
        this.eventTableRepository = eventTableRepository;
        this.courseTimeTableRepository = courseTimeTableRepository;
    }

    public void saveEventTable(EventTable eventTable) {
        eventTableRepository.save(eventTable);
    }

    public void deleteByTableID(Integer tableID) {
        //删除一个table的时候，要连带着把这个table对应的coursetimetable，event，inventory等等全部删除
        final Logger log = Logger.getLogger(EventTableService.class.getName());
        EventTable eventTable = eventTableRepository.getByTableID(tableID);
        eventTable.detach();
        log.info("Deleting event table with tableID: " + tableID);
        courseTimeTableRepository.deleteByEventTableID(tableID);
        eventTableRepository.deleteByTableID(tableID);
    }

    public void delete(EventTable eventTable) {
        eventTable.detach();
        //inventory要删，event也要删（event删除的时候要删除timeconnection和对应的eventtime），coursetimetable也要删
        courseTimeTableRepository.deleteByEventTableID(eventTable.getTableID());
        //TODO；inventory中所有event删除
        eventTableRepository.delete(eventTable);
    }
}

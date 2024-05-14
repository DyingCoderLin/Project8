package org.example.backend.service;

import org.example.backend.repository.EventTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.EventRepository;
import org.springframework.transaction.annotation.Transactional;
import org.example.backend.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;
    private final EventTimeService eventTimeService;

    @Autowired
    public EventService(EventRepository eventRepository, EventTimeService eventTimeService) {
        this.eventRepository = eventRepository;
        this.eventTimeService = eventTimeService;
    }

    //从数据库中根据eventID进行删除
    public void deleteEventByEventID(int eventID) {
        eventRepository.deleteByEventID(eventID);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public void delete(Event event) {
        event.detach();
        List<EventTime> eventTimesToDelete = new ArrayList<>();
        for (EventTime eventTime : event.getEventTimes()) {
            eventTimesToDelete.add(eventTime);
        }
        // 删除临时集合中的 EventTime
        for (EventTime eventTime : eventTimesToDelete) {
            event.getEventTimes().remove(eventTime);
            eventTimeService.delete(eventTime);
        }
        //删除event本身
        eventRepository.delete(event);
    }

    public void updateTime(Event event,CourseTimeTable courseTimeTable){
        for(EventTime eventTime : event.getEventTimes()){
            String[] bothTime = MyUtils.getBothTimeWithCourseTimeTable(eventTime.getStartTimeNumber(),eventTime.getEndTimeNumber(),courseTimeTable);
            String startTime = bothTime[0];
            String endTime = bothTime[1];
            eventTime.setStartTime(startTime);
            eventTime.setEndTime(endTime);
            eventTime.setEvent(event);
            eventTimeService.save(eventTime);
        }
    }
}

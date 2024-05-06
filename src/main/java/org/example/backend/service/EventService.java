package org.example.backend.service;

import org.example.backend.repository.EventTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.EventRepository;
import org.springframework.transaction.annotation.Transactional;
import org.example.backend.model.*;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //从数据库中根据eventID进行删除
    public void deleteEventByEventID(int eventID) {
        eventRepository.deleteByEventID(eventID);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }
}

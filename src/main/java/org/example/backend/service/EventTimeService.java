package org.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.EventTimeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventTimeService {

    private final EventTimeRepository eventTimeRepository;

    @Autowired
    public EventTimeService(EventTimeRepository eventTimeRepository) {
        this.eventTimeRepository = eventTimeRepository;
    }
}

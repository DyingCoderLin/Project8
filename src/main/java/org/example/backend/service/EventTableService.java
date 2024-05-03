package org.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.EventTableRepository;

@Service
public class EventTableService {

    private final EventTableRepository eventTableRepository;

    @Autowired
    public EventTableService(EventTableRepository eventTableRepository) {
        this.eventTableRepository = eventTableRepository;
    }
}

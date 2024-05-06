package org.example.backend.service;

import org.example.backend.repository.TimeConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TimeConnectionService {

    private final TimeConnectionRepository timeConnectionRepository;

    @Autowired
    public TimeConnectionService(TimeConnectionRepository timeConnectionRepository) {
        this.timeConnectionRepository = timeConnectionRepository;
    }
}

package org.example.backend.service;

import org.example.backend.model.EventTable;
import org.example.backend.model.User;
import org.example.backend.repository.EventTableRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final EventTableRepository eventTableRepository;

    @Autowired
    public UserService(UserRepository userRepository, EventTableRepository eventTableRepository) {
        this.userRepository = userRepository;
        this.eventTableRepository = eventTableRepository;
    }

    public User isPasswardCorrect(String userID, String password) {
        User user = userRepository.findByUserID(userID);
        return user;
//        if(user!=null) {
//            return user.getPassword().equals(password);
//        }
//        return false;
    }

    public boolean saveUser(User user) {
        if(userRepository.findByUserID(user.getUserID())==null) {
            userRepository.save(user);
            return true;
        }
        else {
            return false;
        }
    }

    public Set<EventTable> getEventTablesByuserID(String userID) {
        User user = userRepository.findByUserID(userID);
        final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
        log.info("tohere1");
        log.info(user.getUserID());
//        if (user != null) {
            return user.getEventTables();
//        }
//        return null; // or return an empty set if preferred
    }
}

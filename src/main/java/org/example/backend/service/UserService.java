package org.example.backend.service;

import org.example.backend.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isPasswardCorrect(String userID, String password) {
        final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
        log.info("to here0");
        User user = userRepository.findByUserID(userID);
        log.info("to here1");
        if(user!=null) {
            log.info("to here2");
            return user.getPassword().equals(password);
        }
        return false;
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
}

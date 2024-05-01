package org.example.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class LoadController {
    /*
    TODO:
        loadEventInfo 加载单件事件的详细信息到前端
        loadDayVision 加载某一天所有事件的信息到前端
        loadMonthVision 加载某一月所有事件的简要信息到前端
     */

    //向日志中加载receive request


    @PostMapping("/loadEventInfo")
    public String loadEventInfo(String eventId) {
        return "loadEventInfo";
    }

    @PostMapping("/loadDayVision")
    public String loadDayVision(String date) {
        return "loadDayVision";
    }

    @PostMapping("/loadMonthVision")
    public String loadMonthVision(String date) {
        return "loadMonthVision";
    }
}

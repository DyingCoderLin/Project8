package org.example.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.backend.service.*;
import org.example.backend.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class EventController {
    /*
    处理所有存储在数据库的事件相关的请求
    TODO:
        changeEventInfo,当传入的EventID为0时，表示新建事件，否则表示修改事件，待完成，因为外键等都没有构造成功
        deleteEvent
     */
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    //不需要返回值，因为修改后前端为整个重新load来获取当天的所有课程
    public void changeEventInfo(@RequestHeader(value = "Cookie") String cookie,
                                @RequestBody Map<String, Object> requestBody) {
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        String userID = cookieInfo[0];
        Integer tableID = Integer.parseInt(cookieInfo[1]);
        //0为课程，1为日程
        boolean type = (boolean) requestBody.get("type");
        Integer eventID = (Integer) requestBody.get("eventID");
        String eventName = (String) requestBody.get("eventName");
        String eventLocation = (String) requestBody.get("eventLocation");
        String courseCode = (String) requestBody.get("courseCode");
        String weekRepeat = (String) requestBody.get("weekRepeat");
        List<Map<String, Object>> dayRepeatList = (List<Map<String, Object>>) requestBody.get("dayRepeat");
        User user = userService.getUserByUserID(userID);
        //根据userID，tableID先达到对应的eventTable
        EventTable eventTable = user.getEventTableByTableID(tableID);
        Set<DayRepeat> dayRepeats = new HashSet<>();
        //将dayRepeats读取出来，后续存入eventtime
        if(!type){
            //如果是课程，则只看startTimeNumber和endTimeNumber
            for (Map<String, Object> dayRepeatMap : dayRepeatList) {
                int date = (int) dayRepeatMap.get("date");
                int startTimeNumber = (int) dayRepeatMap.get("startTimeNumber");
                int endTimeNumber = (int) dayRepeatMap.get("endTimeNumber");
                DayRepeat dayRepeat = new DayRepeat(date, startTimeNumber, endTimeNumber);
                dayRepeats.add(dayRepeat);
            }
        }
        else {
            //如果是日程，则只看startTime和endTime
            for (Map<String, Object> dayRepeatMap : dayRepeatList) {
                int date = (int) dayRepeatMap.get("date");
                String startTime = (String) dayRepeatMap.get("startTime");
                String endTime = (String) dayRepeatMap.get("endTime");
                DayRepeat dayRepeat = new DayRepeat(date, startTime, endTime);
                dayRepeats.add(dayRepeat);
            }
        }
        Event event = null;
        if(eventID == 0){
            //需要新建事件
            event = new Event();

        }
        else {
            //要找到对应的event，通过eventtable和event的外键进行寻找
        }
        event.setType(type);
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);
        event.setCourseCode(courseCode);
        event.setWeek(weekRepeat);
        eventService.saveEvent(event);
    }

}

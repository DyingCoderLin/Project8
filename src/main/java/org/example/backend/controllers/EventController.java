package org.example.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.backend.service.*;
import org.example.backend.model.*;

import java.util.*;

@RestController
public class EventController {
    /*
    处理所有存储在数据库的事件相关的请求
    TODO:
        changeEventInfo,当传入的EventID为0时，表示新建事件，否则表示修改事件，待完成，因为外键等都没有构造成功
        deleteEvent 删除事件，要将它的eventtime连带着一起删除
     */
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseTimeTableService courseTimeTableService;

    @Autowired
    private EventTimeService eventTimeService;

    //不需要返回值，因为修改后前端为整个重新load来获取当天的所有课程
    @PostMapping("/changeEventInfo")
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
        int date;
        int startTimeNumber = 0;
        int endTimeNumber = 0;
        String startTime = null;
        String endTime = null;
        Event event = null;
        //要先找到对应的event，如果是0则新建，否则找到对应的event
        if(eventID == 0){
            //需要新建事件
            event = new Event();
        }
        else {
            //要找到对应的event，通过eventtable和event的外键进行寻找
            Set<Event> events = eventTable.getEvents();
            for (Event event0 : events) {
                if(Objects.equals(event0.getEventID(), eventID)){
                    event = event0;
                    break;
                }
            }
        }
        event.setType(type);
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);
        event.setCourseCode(courseCode);
        event.setWeek(weekRepeat);
        event.setEventTable(eventTable);
        eventService.saveEvent(event);
        if(!type){
            //如果是课程，则只看startTimeNumber和endTimeNumber
            for (Map<String, Object> dayRepeatMap : dayRepeatList) {
                date = (int) dayRepeatMap.get("date");
                startTimeNumber = (int) dayRepeatMap.get("startTimeNumber");
                endTimeNumber = (int) dayRepeatMap.get("endTimeNumber");
                DayRepeat dayRepeat = new DayRepeat(date, startTimeNumber, endTimeNumber);
                dayRepeats.add(dayRepeat);
            }
            //遍历dayRepeats，把一个Dayrepeat对应存一列eventtime并保存到数据库中
            for (DayRepeat dayRepeat : dayRepeats) {
                EventTime eventTime = new EventTime();
                eventTime.setDate(dayRepeat.getDate());
                startTimeNumber = dayRepeat.getStartTimeNumber();
                endTimeNumber = dayRepeat.getEndTimeNumber();
                //先存入节数，再根据节数算出对应的课程时间，将所有内容都进行存入
                eventTime.setStartTimeNumber(startTimeNumber);
                eventTime.setEndTimeNumber(endTimeNumber);
                //根据courseTimeTable算出对应的课程时间
                String[] bothTime = MyUtils.getBothTimeByTwoNumber(tableID, startTimeNumber, endTimeNumber, courseTimeTableService);
                startTime = bothTime[0];
                endTime = bothTime[1];
                eventTime.setStartTime(startTime);
                eventTime.setEndTime(endTime);
                eventTime.setEvent(event);
                eventTimeService.save(eventTime);
            }
        }
        else {
            //如果为日程，节数直接都标志为0
            //如果是日程，则只看startTime和endTime
            for (Map<String, Object> dayRepeatMap : dayRepeatList) {
                date = (int) dayRepeatMap.get("date");
                startTime = (String) dayRepeatMap.get("startTime");
                endTime = (String) dayRepeatMap.get("endTime");
                DayRepeat dayRepeat = new DayRepeat(date, startTime, endTime);
                dayRepeats.add(dayRepeat);
            }
            for (DayRepeat dayRepeat : dayRepeats) {
                EventTime eventTime = new EventTime();
                eventTime.setDate(dayRepeat.getDate());
                eventTime.setStartTimeNumber(dayRepeat.getStartTimeNumber());
                eventTime.setEndTimeNumber(dayRepeat.getEndTimeNumber());
                eventTime.setStartTime(dayRepeat.getStartTime());
                eventTime.setEndTime(dayRepeat.getEndTime());
                eventTime.setEvent(event);
                eventTimeService.save(eventTime);
            }
        }
    }

    @PostMapping("/deleteEvent")
    public void deleteEvent(@RequestHeader(value = "Cookie") String cookie,
                            @RequestBody Map<String, Object> requestBody) {
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        String userID = cookieInfo[0];
        Integer tableID = Integer.parseInt(cookieInfo[1]);
        Integer eventID = (Integer) requestBody.get("eventID");
        User user = userService.getUserByUserID(userID);
        EventTable eventTable = user.getEventTableByTableID(tableID);
        Set<Event> events = eventTable.getEvents();
        Event event = null;
        for (Event event0 : events) {
            if(Objects.equals(event0.getEventID(), eventID)){
                event = event0;
                break;
            }
        }
        if(event != null){
            //删除event下属的所有eventTimes，再删除event
            //在遍历set的同时删除eventTime会导致并行错误，用迭代器也不行，但是用List就可以，原因不明，但能跑，是好代码
            eventService.delete(event);
//            List<EventTime> eventTimesToDelete = new ArrayList<>();
//            for (EventTime eventTime : event.getEventTimes()) {
//                eventTimesToDelete.add(eventTime);
//            }
//            // 删除临时集合中的 EventTime
//            for (EventTime eventTime : eventTimesToDelete) {
//                event.getEventTimes().remove(eventTime);
//                eventTimeService.delete(eventTime);
//            }
//            //删除event本身
//            eventService.delete(event);
        }
    }

}

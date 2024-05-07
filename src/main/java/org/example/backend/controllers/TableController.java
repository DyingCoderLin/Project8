package org.example.backend.controllers;

import org.example.backend.model.*;
import org.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
public class TableController {
    /*
    处理所有工作表相关的请求
    TODO:
        addTableInfo done，同时该table关联的所有课程的时间都要进行更新
        deleteTable done
        switchTable done
        getAllTableInfo done
    */

    @Autowired
    private UserService userService;

    @Autowired
    private EventTableService eventTableService;

    @Autowired
    private CourseTimeTableService courseTimeTableService;
    @Autowired
    private EventService eventService;

    @PostMapping("/addTableInfo")
    public void addTableInfo(@RequestHeader(value="Cookie") String cookie,
                             @RequestBody Map<String,Object> requestBody) {
        String userID = null;
        Integer tableID = 0;
        String tableName = (String) requestBody.get("tableName");
        String backgroundURL = (String) requestBody.get("backgroundURL");
        String font = (String) requestBody.get("font");
        String courseColor = (String) requestBody.get("courseColor");
        String eventColor = (String) requestBody.get("eventColor");
        String firstDayDate = (String) requestBody.get("firstDayDate");

        Integer weekAmount = 0;
        if(requestBody.get("weekAmount")!=null){
            weekAmount = (Integer) requestBody.get("weekAmount");
        }

        Integer courseNumber = 0;
        if(requestBody.get("courseNum") != null){
            courseNumber = (Integer) requestBody.get("courseNum");
        }


        List<Map<String, String>> courseTimeList = (List<Map<String, String>>) requestBody.get("courseTime");
        List<CourseTime> courseTimes = new ArrayList<>();

        // 遍历数组，创建 CourseTime 对象并添加到列表中
        for (Map<String, String> courseTimeMap : courseTimeList) {
            String startTime = courseTimeMap.get("startTime");
            String endTime = courseTimeMap.get("endTime");
            CourseTime courseTime = new CourseTime(startTime, endTime); // 假设你的 CourseTime 类有一个构造函数接收 startTime 和 endTime
            courseTimes.add(courseTime);
        }

        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
        tableID = Integer.parseInt(cookieInfo[1]);
        //根据userID和tableID找到对应的eventTable
        Set<EventTable> eventTables = userService.getEventTablesByuserID(userID);
        EventTable eventTable = null;
        //找到userID,tableID对应的eventTable
        //还要找到eventTable对应的courseTimeTable
        CourseTimeTable courseTimeTable = null;
        for (EventTable et : eventTables) {
            if (Objects.equals(et.getTableID(), tableID)) {
                eventTable = et;
                break;
            }
        }
        if(eventTable != null) {
            //找到eventTable对应
            courseTimeTable = courseTimeTableService.findByEventTableID(tableID);
            //如果没有对应的表，则创建一个
            if(courseTimeTable == null) {
                courseTimeTable = new CourseTimeTable();
                courseTimeTable.setEventTableID(tableID);
            }
            eventTable.setTableName(tableName);
            eventTable.setBackground(backgroundURL);
            eventTable.setFont(font);
            eventTable.setCourseColor(courseColor);
            eventTable.setEventColor(eventColor);
            eventTable.setFirstDayDate(MyUtils.stringToDate(firstDayDate));
            eventTable.setWeekAmount(weekAmount);
            if(courseNumber != 0) {
                courseTimeTable.setAllCourseTime(courseNumber,courseTimes);
            }
            courseTimeTable.setCourseNumber(courseNumber);
            eventTableService.saveEventTable(eventTable);
            courseTimeTableService.save(courseTimeTable);
            //根据新的courseTime对于各个事件的时间进行更新
            Set<Event> events = eventTable.getEvents();
            for(Event event : events) {
                if(!event.getType()){
                    eventService.updateTime(event,courseTimeTable);
                }
            }
        }

    }

    @PostMapping("/deleteTable")
    public void deleteTable(@RequestHeader(value="Cookie") String cookie) {
        String userID = null;
        Integer tableID = 0;
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
        tableID = Integer.parseInt(cookieInfo[1]);
        //根据userID和tableID找到对应的eventTable
        Set<EventTable> eventTables = userService.getEventTablesByuserID(userID);
        EventTable eventTable = null;
        //找到userID,tableID对应的eventTable
        //还要找到eventTable对应的courseTimeTable
        for (EventTable et : eventTables) {
            if (Objects.equals(et.getTableID(), tableID)) {
                eventTable = et;
                break;
            }
        }
        //TODO：删除eventTable和courseTimeTable和对应的event
        if(eventTable != null) {
            //删除eventtable对应的event

//            //删除eventtable对应的coursetimetable
//            courseTimeTableService.deleteByEventTableID(tableID);
            //删除eventtable本身
            eventTableService.deleteByTableID(tableID);
        }
    }

    @GetMapping("/getAllTableInfo")
    public ResponsetogetAllTableInfo getAllTableInfo(@RequestHeader(value="Cookie") String cookie) {
        String userID = null;
        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        userID = cookieInfo[0];
        //获取所有的eventTable
        Set<EventTable> eventTables = userService.getEventTablesByuserID(userID);
        ResponsetogetAllTableInfo response = new ResponsetogetAllTableInfo();
        response.setCode(1);
        Set<TableArray> tableArrays = new HashSet<>();
        //将eventTable转换为TableArray
        for(EventTable et : eventTables) {
            TableArray tableArray = new TableArray();
            tableArray.setTableArray(et.getTableID(),et.getTableName());
            tableArrays.add(tableArray);
        }
        response.setData(tableArrays.size(),tableArrays);
        return response;
    }

    @PostMapping("/switchTable")
    public ResponsetoswitchTable switchTable(@RequestHeader(value="Cookie") String cookie,
                                             @RequestBody Map<String,Object> requestBody) {

        String[] cookieInfo = MyUtils.getCookieInfo(cookie);
        String userID = cookieInfo[0];
        Integer oldTableID = Integer.parseInt(cookieInfo[1]);
        //要切换过去的表
        Integer newTableID = (Integer)requestBody.get("tableID");
        User user = userService.getUserByUserID(userID);
        EventTable oldEventTable = user.getEventTableByTableID(oldTableID);
        oldEventTable.setDefaultTable(false);
        eventTableService.saveEventTable(oldEventTable);
        if(newTableID == 0){//要为它生成新的EventTable对象并插入数据库，将返回的tableID和Cookie更新
            EventTable newEventTable = new EventTable();
            newEventTable.setUser(user);
            newEventTable.setTableName("新建工作表");
            newEventTable.setDefaultTable(true);
            eventTableService.saveEventTable(newEventTable);
            newTableID = newEventTable.getTableID();
            CourseTimeTable courseTimeTable = new CourseTimeTable();
            courseTimeTable.setEventTableID(newTableID);
            courseTimeTableService.save(courseTimeTable);
        }
        else {
            //根据userID和tableID找到对应的eventTable
            Set<EventTable> eventTables = user.getEventTables();
            EventTable newEventTable = null;
            //找到userID,tableID对应的eventTable
            for (EventTable et : eventTables) {
                if (Objects.equals(et.getTableID(), newTableID)) {
                    newEventTable = et;
                    break;
                }
            }
            if (newEventTable == null) {
                newTableID = 0;
            }
            else {
                newEventTable.setDefaultTable(true);
                eventTableService.saveEventTable(newEventTable);
            }
        }
        cookie = MyUtils.setCookie(userID,newTableID);
        ResponsetoswitchTable response = new ResponsetoswitchTable();
        response.setCode(1);
        response.setData(cookie,newTableID);
        return response;
    }
}

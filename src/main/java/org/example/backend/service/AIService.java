package org.example.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.example.backend.model.Event;
import org.example.backend.model.EventTable;
import org.example.backend.model.ResponseAI;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.model.DayRepeat;

import java.util.Set;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventTableService eventTableService;

    @Autowired
    private ObjectMapper objectMapper;

    @Data
    public class DataforEvent{
        private String eventName;
        private String eventLocation;
        private List<Integer> week;
        private List<DayRepeat> dayRepeat;

        public DataforEvent() {
            week = new ArrayList<>();
            dayRepeat = new ArrayList<>();
        }

        // setters
        public void setEventName(String eventName) {
            this.eventName = eventName;
        }
        public void setEventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
        }
        public void setWeek(List<Integer> week) {
            this.week = week;
        }
        public void setDayRepeat(List<DayRepeat> dayRepeat) {
            this.dayRepeat = dayRepeat;
        }
        public void addDayRepeatforCourse(JsonNode dayRepeat) {
            DayRepeat newDayRepeat = new DayRepeat();
            newDayRepeat.setDate(dayRepeat.get("date").asInt());
            newDayRepeat.setStartTimeNumber(dayRepeat.get("startTimeNumber").asInt());
            newDayRepeat.setEndTimeNumber(dayRepeat.get("endTimeNumber").asInt());
            this.dayRepeat.add(newDayRepeat);
        }
        public void addDayRepeatforSchedule(JsonNode dayRepeat) {
            DayRepeat newDayRepeat = new DayRepeat();
            newDayRepeat.setDate(dayRepeat.get("date").asInt());
            newDayRepeat.setStartTime(dayRepeat.get("startTime").asText());
            newDayRepeat.setEndTime(dayRepeat.get("endTime").asText());
            this.dayRepeat.add(newDayRepeat);
        }
        public void addWeek(Integer week) {
            this.week.add(week);
        }
    }
    public ResponseAI newCourse(JsonNode jsonNode, Integer tableID) {
        Logger log = org.slf4j.LoggerFactory.getLogger(AIService.class);
        EventTable eventTable = eventTableService.getByTableID(tableID);
        String weekRepeat = jsonNode.get("weekRepeat").asText();
        List<Integer> week = new ArrayList<>();

        //认为周数从0开始，到weekAmount-1
        log.info("weekRepeat: " + weekRepeat);
        DataforEvent data = new DataforEvent();
        if(weekRepeat.equals("每周")) {
            for(int i = 0; i < eventTable.getWeekAmount(); i++) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("单周")) {
            for(int i = 0; i < eventTable.getWeekAmount(); i+=2) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("双周")) {
            for(int i = 1; i < eventTable.getWeekAmount(); i+=2) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("本周")) {
            //获得当前时间，然后计算出当前周数
            Date todayDate = new Date(System.currentTimeMillis());
            int weekNow = MyUtils.DateToWeekandDay(eventTable.getFirstDayDate(),todayDate)[0]-1;
            data.addWeek(weekNow);
        } else if(weekRepeat.equals("下周")) {
            Date todayDate = new Date(System.currentTimeMillis());
            int weekNext = MyUtils.DateToWeekandDay(eventTable.getFirstDayDate(),todayDate)[0];
            data.addWeek(weekNext);
        } else {
            weekRepeat = "";
            JsonNode weekNode = jsonNode.get("week");
            if(weekNode.isArray()){
                for(JsonNode weekNumber : weekNode) {
                    log.info("weekNumber: " + weekNumber.asInt());
                    data.addWeek(weekNumber.asInt());
                }
            }
        }
        String eventName = jsonNode.get("eventName").asText();
        String eventLocation = jsonNode.get("eventLocation").asText();
        data.setEventName(eventName);
        data.setEventLocation(eventLocation);
        JsonNode dayRepeat = jsonNode.get("dayRepeat");
        if(dayRepeat.isArray()) {
            for(JsonNode dayRepeatNode : dayRepeat) {
                data.addDayRepeatforCourse(dayRepeatNode);
            }
        }
        return new ResponseAI<DataforEvent>(0,data);
    }

    public ResponseAI newSchedule(JsonNode jsonNode,Integer tableID) {
        Logger log = org.slf4j.LoggerFactory.getLogger(AIService.class);
        EventTable eventTable = eventTableService.getByTableID(tableID);
        String weekRepeat = jsonNode.get("weekRepeat").asText();
        List<Integer> week = new ArrayList<>();

        //认为周数从0开始，到weekAmount-1
        log.info("weekRepeat: " + weekRepeat);
        DataforEvent data = new DataforEvent();
        if(weekRepeat.equals("每周")) {
            for(int i = 0; i < eventTable.getWeekAmount(); i++) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("单周")) {
            for(int i = 0; i < eventTable.getWeekAmount(); i+=2) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("双周")) {
            for(int i = 1; i < eventTable.getWeekAmount(); i+=2) {
                data.addWeek(i);
            }
        } else if(weekRepeat.equals("本周")) {
            //获得当前时间，然后计算出当前周数
            Date todayDate = new Date(System.currentTimeMillis());
            int weekNow = MyUtils.DateToWeekandDay(eventTable.getFirstDayDate(),todayDate)[0]-1;
            data.addWeek(weekNow);
        } else if(weekRepeat.equals("下周")) {
            Date todayDate = new Date(System.currentTimeMillis());
            int weekNext = MyUtils.DateToWeekandDay(eventTable.getFirstDayDate(),todayDate)[0];
            data.addWeek(weekNext);
        } else {
            weekRepeat = "";
            JsonNode weekNode = jsonNode.get("week");
            if(weekNode.isArray()){
                for(JsonNode weekNumber : weekNode) {
                    log.info("weekNumber: " + weekNumber.asInt());
                    data.addWeek(weekNumber.asInt());
                }
            }
        }
        String eventName = jsonNode.get("eventName").asText();
        String eventLocation = jsonNode.get("eventLocation").asText();
        data.setEventName(eventName);
        data.setEventLocation(eventLocation);
        JsonNode dayRepeat = jsonNode.get("dayRepeat");
        if(dayRepeat.isArray()) {
            for(JsonNode dayRepeatNode : dayRepeat) {
                data.addDayRepeatforSchedule(dayRepeatNode);
            }
        }
        return new ResponseAI<DataforEvent>(0,data);
    }

    public ResponseAI switchTable(String tableName) {
        @Data
        class DataForSwitchTable {
            private Integer tableID;
            private String message;
            public DataForSwitchTable(String message, Integer tableID) {
                this.message = message;
                this.tableID = tableID;
            }
            public DataForSwitchTable(){
                this.message = "没有找到您要切换的工作表";
                this.tableID = 0;
            }
        }
        DataForSwitchTable data = new DataForSwitchTable();
        List<EventTable> eventTabless = eventTableService.findByTableNameContaining(tableName);
        if(eventTabless.isEmpty()) {
            return new ResponseAI<DataForSwitchTable>(2,data);
        }
        EventTable eventTable = eventTabless.get(0);

        data.setTableID(eventTable.getTableID());
        String message = "是否切换到工作表：\"" + eventTable.getTableName() +"\"？";
        data.setMessage(message);
        return new ResponseAI<DataForSwitchTable>(2,data);
    }

    public ResponseAI createTable(JsonNode jsonNode) {
        @Data
        class DataForCreateTable {
            private String tableName;
            private String font;
            private Integer weekAmount;
            private String message;
            public DataForCreateTable(String tableName, String font, Integer weekAmount,String message) {
                this.tableName = tableName;
                this.font = font;
                this.weekAmount = weekAmount;
                this.message = message;
            }
        }
        String tableName = jsonNode.get("tableName").asText();
        String font = jsonNode.get("font").asText();
        Integer weekAmount = jsonNode.get("weekAmount").asInt();
        String message = "是否创建工作表：\"" + tableName + "\"？";
        DataForCreateTable data = new DataForCreateTable(tableName,font,weekAmount,message);
        return new ResponseAI<DataForCreateTable>(3,data);
    }

    public ResponseAI deleteEvent(JsonNode jsonNode) {
        @Data
        class DataForDeleteEvent {
            private Integer eventID;
            private String message;
            public DataForDeleteEvent(Integer eventID,String message) {
                this.eventID = eventID;
                this.message = message;
            }
        }
        String eventName = jsonNode.get("eventName").asText();
        List<Event> events = eventService.findByEventNameContaining(eventName);
        DataForDeleteEvent data;
        if(events.isEmpty()) {
            data = new DataForDeleteEvent(0,"没有找到您要删除的日程或课程：\""+eventName+"\"。");
            return new ResponseAI(4,data);
        }
        //取第一个元素
        Event event = events.get(0);
        Integer eventID = event.getEventID();
        String message;
        if(event.getType())
            message = "是否删除日程：\"" + event.getEventName() + "\"？";
        else
            message = "是否删除课程：\"" + event.getEventName() + "\"？";
        data = new DataForDeleteEvent(eventID,message);
        return new ResponseAI<DataForDeleteEvent>(4,data);
    }

    public ResponseAI deleteTable(JsonNode jsonNode) {
        @Data
        class DataForDeleteTable {
            private Integer tableID;
            private String message;
            public DataForDeleteTable(Integer tableID,String message) {
                this.tableID = tableID;
                this.message = message;
            }
        }
        String tableName = jsonNode.get("tableName").asText();
        List<EventTable> eventTables = eventTableService.findByTableNameContaining(tableName);
        if(eventTables.isEmpty()) {
            DataForDeleteTable data = new DataForDeleteTable(0,"没有找到您要删除的工作表：\""+tableName+"\"。");
            return new ResponseAI(5,data);
        }
        EventTable eventTable = eventTables.get(0);
        DataForDeleteTable data;
//        if(eventTable.getDefaultTable()) {
//            data = new DataForDeleteTable(eventTable.getTableID(),"默认工作表无法删除。");
//            return new ResponseAI<DataForDeleteTable>(5,data);
//        }
        data = new DataForDeleteTable(eventTable.getTableID(),"是否删除工作表：\"" + eventTable.getTableName() + "\"？");
        return new ResponseAI<DataForDeleteTable>(5,data);
    }

    public ResponseAI defaultSetting() {
        return new ResponseAI(-1,"无法识别");
    }
}

package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventID;

    @Column(name = "type")
    private boolean type;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventLocation")
    private String eventLocation;

    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "isImportant")
    private boolean isImportant;

    @Column(name = "week")
    private String week;

    public Event() {
    }

    //不需要声明id，因为generationtype会自动生成id
    public Event(boolean type, String eventName, String eventLocation, String courseCode, boolean isImportant, String week) {
        this.type = type;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.courseCode = courseCode;
        this.isImportant = isImportant;
        this.week = week;
    }

    // getters
    public Integer getEventID() { return eventID; }
    public boolean getType() { return type; }
    public String getEventName() { return eventName; }
    public String getEventLocation() { return eventLocation; }
    public String getCourseCode() { return courseCode; }
    public boolean getIsImportant() { return isImportant; }
    public String getWeek() { return week; }

    // setters
    public void setEventID(Integer eventID) { this.eventID = eventID; }
    public void setType(boolean type) { this.type = type; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setIsImportant(boolean isImportant) { this.isImportant = isImportant; }
    public void setWeek(String week) { this.week = week; }

}

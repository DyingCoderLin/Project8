package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "eventtime")
public class EventTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventTimeID;

    @Column(name = "date")
    private Integer date;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    public EventTime() {
    }

    public EventTime(Integer date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // getters
    public Integer getEventTimeID() { return eventTimeID; }
    public Integer getDate() { return date; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    // setters
    public void setEventTimeID(Integer eventTimeID) { this.eventTimeID = eventTimeID; }
    public void setDate(Integer date) { this.date = date; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}

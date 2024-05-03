package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "timeconnection")
public class TimeConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventtime_id;

    @Column(name = "event_id")
    private Integer event_id;

    public TimeConnection() {
    }

    public TimeConnection(Integer event_id) {
        this.event_id = event_id;
    }

    // getters
    public Integer getEventtime_id() { return eventtime_id; }
    public Integer getEvent_id() { return event_id; }

    // setters
    public void setEventtime_id(Integer eventtime_id) { this.eventtime_id = eventtime_id; }
    public void setEvent_id(Integer event_id) { this.event_id = event_id; }
}

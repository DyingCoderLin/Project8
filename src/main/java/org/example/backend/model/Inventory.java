package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventory_id;

    @Column(name = "event_id")
    private Integer eventID;

    @Column(name = "table_id")
    private Integer tableID;

    public Inventory() {
    }

    public Inventory(Integer eventID, Integer tableID) {
        this.eventID = eventID;
        this.tableID = tableID;
    }

    // getters
    public Integer getInventory_id() { return inventory_id; }
    public Integer getEventID() { return eventID; }
    public Integer getTableID() { return tableID; }

    // setters
    public void setInventory_id(Integer inventory_id) { this.inventory_id = inventory_id; }
    public void setEventID(Integer eventID) { this.eventID = eventID; }
    public void setTableID(Integer tableID) { this.tableID = tableID; }
}

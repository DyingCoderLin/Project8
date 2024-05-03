package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventory_id;

    @Column(name = "event_id")
    private Integer event_id;

    @Column(name = "table_id")
    private Integer table_id;

    public Inventory() {
    }

    public Inventory(Integer event_id, Integer table_id) {
        this.event_id = event_id;
        this.table_id = table_id;
    }

    // getters
    public Integer getInventory_id() { return inventory_id; }
    public Integer getEvent_id() { return event_id; }
    public Integer getTable_id() { return table_id; }

    // setters
    public void setInventory_id(Integer inventory_id) { this.inventory_id = inventory_id; }
    public void setEvent_id(Integer event_id) { this.event_id = event_id; }
    public void setTable_id(Integer table_id) { this.table_id = table_id; }
}

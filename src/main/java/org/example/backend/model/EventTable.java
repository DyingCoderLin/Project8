package org.example.backend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "eventtable")
public class EventTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableID;

    @Column(name = "tableName")
    private String tableName;

    @Column(name = "background")
    private String background;

    @Column(name = "font")
    private String font;

    @Column(name = "courseColor")//课程快颜色
    private Integer courseColor;

    @Column(name = "eventColor")//日程块颜色
    private Integer eventColor;

    @Column(name = "firstDayDate")
    private Date firstDayDate;

    @Column(name = "weekAmount")
    private Integer weekAmount;

    @Column(name = "defaulttable")
    private boolean defaultTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "for_userID")
    private User user;

    public EventTable() {
    }

    public EventTable(Integer tableID,String tableName, String background, String font, Integer courseColor, Integer eventColor, Date firstDayDate, Integer weekAmount,boolean defaultTable) {
        this.tableID = tableID;
        this.tableName = tableName;
        this.background = background;
        this.font = font;
        this.courseColor = courseColor;
        this.eventColor = eventColor;
        this.firstDayDate = firstDayDate;
        this.weekAmount = weekAmount;
        this.defaultTable = false;
//        this.for_userID = for_userID;
    }

    // getters
    public Integer getTableID() { return tableID; }
    public String getTableName() { return tableName; }
    public String getBackground() { return background; }
    public String getFont() { return font; }
    public Integer getCourseColor() { return courseColor; }
    public Integer getEventColor() { return eventColor; }
    public Date getFirstDayDate() { return firstDayDate; }
    public Integer getWeekAmount() { return weekAmount; }
//    public String getFor_userID() { return for_userID; }
//    public String getFor_userID() { return user.getUserID(); }
    public User getUser() { return user; }
    public boolean getDefaultTable() { return defaultTable; }

    // setters
    public void setTableID(Integer tableID) { this.tableID = tableID; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setBackground(String background) { this.background = background; }
    public void setFont(String font) { this.font = font; }
    public void setCourseColor(Integer courseColor) { this.courseColor = courseColor; }
    public void setEventColor(Integer eventColor) { this.eventColor = eventColor; }
    public void setFirstDayDate(Date firstDayDate) { this.firstDayDate = firstDayDate; }
    public void setWeekAmount(Integer weekAmount) { this.weekAmount = weekAmount; }
//    public void setFor_userID(String for_userID) { this.for_userID = for_userID; }
    public void setUser(User user) {
        this.user = user;
    }
    public void setDefaultTable(boolean defaultTable) { this.defaultTable = defaultTable; }
}

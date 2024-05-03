package org.example.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String userID;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userGender")
    private boolean userGender;

    @Column(name = "password")
    private String password;

    @Column(name = "userLocation")
    private String userLocation;

    @Column(name = "AvatarURL")
    private String AvatarURL;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EventTable> eventTables;

    public User() {
    }

    public User(String userID,String userName, boolean userGender, String password, String userLocation, String AvatarURL) {
        this.userID = userID;
        this.userName = userName;
        this.userGender = userGender;
        this.password = password;
        this.userLocation = userLocation;
        this.AvatarURL = AvatarURL;
    }

    // getters
    public String getUserID() { return userID; }
    public String getUserName() { return userName; }
    public boolean getUserGender() { return userGender; }
    public String getPassword() { return password; }
    public String getUserLocation() { return userLocation; }
    public String getAvatarURL() { return AvatarURL; }
    public Set<EventTable> getEventTables() { return eventTables; }

    // setters
    public void setUserID(String userID) { this.userID = userID; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserGender(boolean userGender) { this.userGender = userGender; }
    public void setPassword(String password) { this.password = password; }
    public void setUserLocation(String userLocation) { this.userLocation = userLocation; }
    public void setAvatarURL(String AvatarURL) { this.AvatarURL = AvatarURL; }
    public void setEventTables(Set<EventTable> eventTables) { this.eventTables = eventTables; }

}

package com.nju.meanlay.hiking.Model;

import java.io.Serializable;

public class Event implements Serializable {
    private long id;
    private int status;
    private String date;
    private String category;
    private String location;
    private String imgUrl;
    private String title;
    private String description;
    private EventMember[] waitingMembers;
    private EventMember[] joinedMembers;
    private EventMember[] rejectedMembers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventMember[] getWaitingMembers() {
        return waitingMembers;
    }

    public void setWaitingMembers(EventMember[] waitingMembers) {
        this.waitingMembers = waitingMembers;
    }

    public EventMember[] getJoinedMembers() {
        return joinedMembers;
    }

    public void setJoinedMembers(EventMember[] joinedMembers) {
        this.joinedMembers = joinedMembers;
    }

    public EventMember[] getRejectedMembers() {
        return rejectedMembers;
    }

    public void setRejectedMembers(EventMember[] rejectedMembers) {
        this.rejectedMembers = rejectedMembers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
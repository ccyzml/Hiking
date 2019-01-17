package com.nju.meanlay.hiking.Model;

import java.io.Serializable;

public class Event implements Serializable {
    private long id;
    private int status;
    private String date;
    private String startDate;
    private String location;
    private String imgUrl;
    private String title;
    private String description;
    private EventMember[] waitingMembers;
    private EventMember[] joinedMembers;
    private long[] ownerIds;
    private int memberCount;
    private float fee;

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


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long[] getOwnerIds() {
        return ownerIds;
    }

    public void setOwnerIds(long[] ownerIds) {
        this.ownerIds = ownerIds;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}

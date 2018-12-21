package com.nju.meanlay.hiking.Model;

import java.io.Serializable;

public class User implements Serializable {
    private long uid;
    private String bornDate;
    private String nickName;
    private String introduction;
    private String avatarUrl;
    private String University;
    private String college;
    private Friend[] friends;
    private Event[] runningEvents;
    private Event[] comingEvents;
    private Event[] endedEvents;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Friend[] getFriends() {
        return friends;
    }

    public void setFriends(Friend[] friends) {
        this.friends = friends;
    }

    public Event[] getRunningEvents() {
        return runningEvents;
    }

    public void setRunningEvents(Event[] runningEvents) {
        this.runningEvents = runningEvents;
    }

    public Event[] getComingEvents() {
        return comingEvents;
    }

    public void setComingEvents(Event[] comingEvents) {
        this.comingEvents = comingEvents;
    }

    public Event[] getEndedEvents() {
        return endedEvents;
    }

    public void setEndedEvents(Event[] endedEvents) {
        this.endedEvents = endedEvents;
    }
}

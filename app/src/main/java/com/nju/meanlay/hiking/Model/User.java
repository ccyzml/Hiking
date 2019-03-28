package com.nju.meanlay.hiking.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private long uid;
    private String bornDate;
    private String nickName;
    private String introduction;
    private int avatarUrl;
    private String university;
    private String college;
    private Friend[] friends;
    private ArrayList<Event> runningEvents = new ArrayList<>();
    private ArrayList<Event> comingEvents = new ArrayList<>();
    private ArrayList<Event> endedEvents = new ArrayList<>();
    private ArrayList<Event> collectedEvents = new ArrayList<>();

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

    public int getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(int avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
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

    public ArrayList<Event> getRunningEvents() {
        return runningEvents;
    }

    public void setRunningEvents(ArrayList<Event> runningEvents) {
        this.runningEvents = runningEvents;
    }

    public ArrayList<Event> getComingEvents() {
        return comingEvents;
    }

    public void setComingEvents(ArrayList<Event> comingEvents) {
        this.comingEvents = comingEvents;
    }

    public ArrayList<Event> getEndedEvents() {
        return endedEvents;
    }

    public void setEndedEvents(ArrayList<Event> endedEvents) {
        this.endedEvents = endedEvents;
    }

    public void collect(Event event){
        collectedEvents.add(event);
    }

    public ArrayList<Event> getCollectedEvents() {
        return collectedEvents;
    }

    public void setCollectedEvents(ArrayList<Event> collectedEvents) {
        this.collectedEvents = collectedEvents;
    }
}

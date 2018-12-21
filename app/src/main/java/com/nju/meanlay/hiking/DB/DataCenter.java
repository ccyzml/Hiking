package com.nju.meanlay.hiking.DB;

import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.Model.User;

public class DataCenter {
    Event[] events = new Event[10];
    private static final DataCenter ourInstance = new DataCenter();

    public static DataCenter getInstance() {
        return ourInstance;
    }

    private DataCenter() {
        EventMember[] joinedMembers = new EventMember[10];
        EventMember[] waitingMembers = new EventMember[10];
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            member.setStatus(1);
            member.setNickName("GuGu");
            member.setUniversity("南京大学");
            joinedMembers[i] = member;
        }
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            member.setStatus(0);
            member.setNickName("GuGu");
            member.setUniversity("南京大学");
            waitingMembers[i] = member;
        }
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setTitle("Hiking!!!!!!!!");
            event.setJoinedMembers(joinedMembers);
            event.setWaitingMembers(waitingMembers);
            events[i] = event;
        }

    }

    public Event[] getEvents() {
        return events;
    }


}

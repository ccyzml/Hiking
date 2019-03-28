package com.nju.meanlay.hiking.DB;

import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;

public class DataCenter {
    ArrayList<Event> events = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    private static final DataCenter ourInstance = new DataCenter();

    public static DataCenter getInstance() {
        return ourInstance;
    }

    public static Event createEvent() {
        Event event = new Event();
        event.setTitle("Hiking!!!!!!!!");
        event.setFee((float) 150.5);
        event.setLocation("西湖");
        event.setOwnerIds(new long[1]);
        event.setMemberCount(20);
        event.setDescription("一起出游吧！");
        event.setImgUrl(R.mipmap.error_default+"");
        event.setStartDate("2018-12-1");
        event.setDate("2019-1-1");
        EventMember[] joinedMembers = new EventMember[10];
        EventMember[] waitingMembers = new EventMember[10];
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(1);
            user.setNickName("user"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test);
            member.setUser(user);
            joinedMembers[i] = member;
        }
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(0);
            user.setNickName("user"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test);
            member.setUser(user);
            waitingMembers[i] = member;
        }
        event.setJoinedMembers(joinedMembers);
        event.setWaitingMembers(waitingMembers);
        return event;
    }

    private DataCenter() {
        EventMember[] joinedMembers = new EventMember[10];
        EventMember[] waitingMembers = new EventMember[10];
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(1);
            user.setNickName("user"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test);
            member.setUser(user);
            joinedMembers[i] = member;
        }
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(0);
            user.setNickName("user"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test);
            member.setUser(user);
            waitingMembers[i] = member;
        }
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setTitle("Hiking!!!!!!!!"+i);
            event.setFee((float) 150.5);
            event.setLocation("西湖"+i);
            event.setOwnerIds(new long[1]);
            event.setMemberCount(20);
            event.setDescription("一起出游吧！");
            event.setImgUrl(R.mipmap.error_default+"");
            event.setStartDate("2018-12-1");
            if(i == 0) {
                event.setDate("2019-1-1");
            }else {
                event.setDate("2019-1-10");
            }
            event.setJoinedMembers(joinedMembers);
            event.setWaitingMembers(waitingMembers);
            events.add(event);
        }

        for (int i = 0 ; i<10;i++) {
            User user = new User();
            user.setNickName("user"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test);
            users.add(user);
        }

    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


}

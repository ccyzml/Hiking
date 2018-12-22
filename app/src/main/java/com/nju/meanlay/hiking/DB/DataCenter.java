package com.nju.meanlay.hiking.DB;

import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

public class DataCenter {
    Event[] events = new Event[10];
    User[] users = new User[10];
    private static final DataCenter ourInstance = new DataCenter();

    public static DataCenter getInstance() {
        return ourInstance;
    }

    private DataCenter() {
        EventMember[] joinedMembers = new EventMember[10];
        EventMember[] waitingMembers = new EventMember[10];
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(1);
            user.setNickName("GuGu"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test+"");
            member.setUser(user);
            joinedMembers[i] = member;
        }
        for (int i = 0; i < 10;i ++) {
            EventMember member = new EventMember();
            User user = new User();
            member.setStatus(0);
            user.setNickName("GuGu"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test+"");
            member.setUser(user);
            waitingMembers[i] = member;
        }
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setTitle("Hiking!!!!!!!!"+i);
            event.setFee((float) 150.5);
            event.setLocation("西湖"+i);
            event.setOwnerIds(new long[1]);
            event.setMemberCount(100);
            event.setImgUrl(R.mipmap.error_default+"");
            event.setStartDate("2018-12-1");
            if(i == 0) {
                event.setDate("2019-1-1");
            }else {
                event.setDate("2019-1-10");
            }
            event.setJoinedMembers(joinedMembers);
            event.setWaitingMembers(waitingMembers);
            events[i] = event;
        }

        for (int i = 0 ; i<10;i++) {
            User user = new User();
            user.setNickName("GuGu"+i);
            user.setUniversity("南京大学");
            user.setAvatarUrl(R.mipmap.avatar_test+"");
            users[i] = user;
        }

    }

    public Event[] getEvents() {
        return events;
    }

    public User[] getUsers() {
        return users;
    }


}

package com.nju.meanlay.hiking.Model;

import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.R;

import java.util.ArrayList;

public class TestUser {
    private static User user;
    public static User getUser() {
        if (user == null) {
            user = new User();
            user.setNickName("Meanlay");
            user.setUniversity("南京大学");
            user.setCollege("软件学院");
            user.setIntroduction("性感荷官，在线发牌");
            user.setAvatarUrl(R.mipmap.avatar_test);
            user.setBornDate("1994-02-12");

            ArrayList<Event> endedEvents = new ArrayList<>();
            endedEvents.add(DataCenter.createEvent());
            user.setEndedEvents(endedEvents);
        }
        return user;
    }
}

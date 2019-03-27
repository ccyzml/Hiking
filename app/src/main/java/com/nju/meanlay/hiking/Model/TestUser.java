package com.nju.meanlay.hiking.Model;

import com.nju.meanlay.hiking.R;

public class TestUser {
    private static User user;
    public static User getUser() {
        if (user == null) {
            user = new User();
            user.setNickName("Meanlay");
            user.setUniversity("南京大学");
            user.setCollege("软件学院");
            user.setIntroduction("haahahahahahahah");
            user.setAvatarUrl(R.mipmap.avatar_test+"");
        }
        return user;
    }
}

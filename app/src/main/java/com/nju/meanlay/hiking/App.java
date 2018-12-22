package com.nju.meanlay.hiking;

import com.nju.meanlay.hiking.Model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class App {
    private User user;
    private static final App ourInstance = new App();
    public static App getInstance() {
        return ourInstance;
    }

    private App() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNowDate(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);
        return temp_str;
    }


}

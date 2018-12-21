package com.nju.meanlay.hiking;

import com.nju.meanlay.hiking.Model.User;

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
}

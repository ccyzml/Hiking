package com.nju.meanlay.hiking.Model;

import java.io.Serializable;

public class EventMember implements Serializable {
    private User user;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

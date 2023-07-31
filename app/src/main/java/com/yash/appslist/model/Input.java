package com.yash.appslist.model;

import java.util.List;

public class Input {
//    private V __v;
    private List<App> apps;
    private String userId;

//    public Input(V __v, List<App> apps, String userId) {
    public Input(List<App> apps, String userId) {
//        this.__v = __v;
        this.apps = apps;
        this.userId = userId;
    }

//    public V get__v() {
//        return __v;
//    }

//    public void set__v(V __v) {
//        this.__v = __v;
//    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package com.yash.appslist.model;


public class App {
    private String appName;
    private Date date;
    private boolean isInstalled;

    public App(String appName, Date date, boolean isInstalled) {
        this.appName = appName;
        this.date = date;
        this.isInstalled = isInstalled;
    }

    public String getAppName() {
        return appName;
    }

    public Date getDate() {
        return date;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    // You can optionally override the toString(), equals(), and hashCode() methods here
    // to provide meaningful representations and comparisons for the object.
}


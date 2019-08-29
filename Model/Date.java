package com.example.istiqomahnw.astgafirullah.Model;

/**
 * Created by ISTIQOMAH NW on 01/07/2019.
 */

public class Date {
    private String date;
    private String count;
    public Date() {
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Date(String date , String count) {
        this.date = date;
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

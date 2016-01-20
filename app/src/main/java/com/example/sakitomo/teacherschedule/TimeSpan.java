package com.example.sakitomo.teacherschedule;

/**
 * Created by sakitomo on 2016/01/14.
 */
public class TimeSpan {
    private int day;
    private int start;
    private int end;
    private String desc;

    public TimeSpan(int day, int start, int end, String desc) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.desc = desc;
    }

    public TimeSpan(int day, int start, int end) {
        this(day, start, end, "Office Hour");
    }

    public TimeSpan() {
        this(-1, 0, 0, "");
    }

    public int getDay() {
        return day;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getDesc() {
        return desc;
    }

}

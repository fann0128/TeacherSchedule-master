package com.example.sakitomo.teacherschedule;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by sakitomo on 2016/01/14.
 */
public class Availability {

    // Attributes

    private static final int DAYS_OF_WEEK = 5;
    private ArrayList<TimeSpan>[] week;

    // Constructors

    public Availability(TimeSpan... listOfTime) {
        this();
        for (int i = 0; i < listOfTime.length; i++) {
            TimeSpan time = listOfTime[i];
            this.week[time.getDay()].add(time);
        }
    }

    public Availability() {
        this.week = new ArrayList[DAYS_OF_WEEK];
        for (int i = 0; i < DAYS_OF_WEEK; i++) {
            this.week[i] = new ArrayList<>();
        }
    }

    // Getters & Setters

    public ArrayList<TimeSpan>[] getList() {
        return week;
    }
    public ArrayList<TimeSpan> getList(int i) {
        return week[i];
    }


    // Methods

    public void AddTimeSpan(int i, TimeSpan span) {
        week[i].add(span);
    }

}

package com.example.sakitomo.teacherschedule;

import java.io.Serializable;

/**
 * Created by yangf on 2016/1/20.
 */
public class OfficeHour implements Serializable {

    private int OfficeRoom;
    private String teacherName;
    private int dayOfWeek;
    private int startTime;
    private int endTime;
    private int duration;
    private String subject;
    private String desc;

    public OfficeHour(int officeRoom, String teacherName, int dayOfWeek, int startTime, int endTime, int duration, String subject, String desc) {
        OfficeRoom = officeRoom;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.subject = subject;
        this.desc = desc;
    }

    public OfficeHour(int officeRoom, String teacherName, int dayOfWeek, int startTime, int endTime, String subject, String desc) {
        OfficeRoom = officeRoom;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = endTime-startTime;
        this.subject = subject;
        this.desc = desc;
    }

    public int getOfficeRoom() {
        return OfficeRoom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getSubject() {
        return subject;
    }

    public String getDesc() {
        return desc;
    }
}

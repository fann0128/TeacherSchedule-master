package com.example.sakitomo.teacherschedule;

/**
 * Created by sakitomo on 2016/01/14.
 */
public class Teacher {

    // Attributes

    private String name;
    private Availability availability;

    // Constructors

    public Teacher(String name, Availability availability) {
        this.name = name;
        this.availability = availability;
    }

    public Teacher(String name) {
        this(name, new Availability());
    }

    public Teacher() {
        this(null, new Availability());
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public Availability getAvailability() {
        return availability;
    }

    // Methods

    public String toString() {
        return name;
    }


}

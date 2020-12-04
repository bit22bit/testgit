package com.example.jobbox.models;

public class Postlist {
    String headline, Location,Salary,Language,Experience;

    public Postlist(String headline, String Location, String Salary, String Language, String Experience) {
        this.headline = headline;
        this.Location = Location;
        this.Salary = Salary;
        this.Language = Language;
        this.Experience = Experience;
    }
    public Postlist(){}

    public String getheadline() {
        return headline;
    }

    public void setheadline(String headline) {
        this.headline = headline;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }
}


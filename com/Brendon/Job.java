package com.Brendon;


import java.util.Date;

public class Job {

    private String address;
    private String problem;
    private Date date;
    private String furType;


    public Job(String location, String issue,String type, Date date) {

        this.address = location;
        this.problem = issue;
        this.furType = type;
        this.date = date;


    }

    @Override
    public String toString() {

        return "Furnace issue: " + address + problem + furType + date;
    }
}

package com.Brendon;

import java.util.Calendar;
import java.util.Date;


public class jobAC {

    private String address;
    private String problem;
    private Date date = Calendar.getInstance().getTime();
    private String type;


    public jobAC(String location, String issue,String type, Date date) {

        this.address = location;
        this.problem = issue;
        this.type = type;
        this.date = date;


    }

    @Override
    public String toString() {

        return "Air Conditioning: " + "Location: " + address + " Issue: " + problem +
                " AC Type: " + type + " Date Requested: " + date;
    }

}

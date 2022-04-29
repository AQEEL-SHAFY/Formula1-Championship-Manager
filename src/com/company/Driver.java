package com.company;

import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String nameOfTheDriver;
    private String locationOfTheDriver;
    private String teamOfTheDriver;

    public Driver() {}

    public Driver(String nameOfTheDriver, String locationOfTheDriver,String teamOfTheDriver) {
        this.nameOfTheDriver = nameOfTheDriver;
        this.locationOfTheDriver = locationOfTheDriver;
        this.teamOfTheDriver=teamOfTheDriver;

    }

    public String getNameOfTheDriver() {

        return nameOfTheDriver;
    }

    public void setNameOfTheDriver(String nameOfTheDriver) {

        this.nameOfTheDriver = nameOfTheDriver;
    }

    public String getLocationOfTheDriver() {

        return locationOfTheDriver;
    }

    public void setLocationOfTheDriver(String locationOfTheDriver) {

        this.locationOfTheDriver = locationOfTheDriver;
    }

    public String getTeamOfTheDriver() {

        return teamOfTheDriver;
    }

    public void setTeamOfTheDriver(String teamOfTheDriver) {

        this.teamOfTheDriver = teamOfTheDriver;
    }
}



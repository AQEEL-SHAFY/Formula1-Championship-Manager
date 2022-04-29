package com.company;

import java.io.Serializable;

public class AddRaces implements Serializable {//class ---> AddRace
    private int firstPosition = 0;
    private int secondPosition = 0;
    private int thirdPosition = 0;
    private int racesPlayed = 0;
    private int pts = 0;
    public AddRaces(){}


    public AddRaces(int firstPosition, int secondPosition, int thirdPosition, int racesPlayed, int pts) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.racesPlayed = racesPlayed;
        this.pts = pts;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(int secondPosition) {
        this.secondPosition = secondPosition;
    }



    public int getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(int thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public int getRacesPlayed() {
        return racesPlayed;
    }

    public void setRacesPlayed(int racesPlayed) {
        this.racesPlayed = racesPlayed;
    }

    public int getPts() { return pts; }

    public void setPts(int pts) {
        this.pts = pts;
    }
}

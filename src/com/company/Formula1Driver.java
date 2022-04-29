package com.company;

public class Formula1Driver extends Driver {
    private int numOfFirstPosition=0;
    private int numOfSecondPosition=0;
    private int numOfThirdPosition=0;
    private int numOfRaces=0;
    private int numOfPoints=0;


    private int counterForFirstPosition;
    private int counterForSecondPosition;
    private int counterForThirdPosition;
    private int counterForPoints;
    private int counterForRacesPlayed;

    private int counterForPosition;
    private int counterForStartPosition;
    private String probability;
    private String date;


    public Formula1Driver(){}

    public Formula1Driver(String nameOfTheDriver, String locationOfTheDriver,String teamOfTheDriver) {
        super(nameOfTheDriver,locationOfTheDriver,teamOfTheDriver);
    }
    public Formula1Driver(String nameOfTheDriver, String locationOfTheDriver ,String teamOfTheDriver, int numOfFirstPosition, int numOfSecondPosition, int numOfThirdPosition, int numOfRaces, int numOfPoints,int counterForFirstPosition,int counterForSecondPosition,int counterForThirdPosition,int counterForPoints,int counterForRacesPlayed,int counterForPosition,int counterForStartPosition,String probability,String date) {
        super(nameOfTheDriver, locationOfTheDriver,teamOfTheDriver);
        this.numOfFirstPosition = numOfFirstPosition;
        this.numOfSecondPosition = numOfSecondPosition;
        this.numOfThirdPosition = numOfThirdPosition;
        this.numOfRaces = numOfRaces;
        this.numOfPoints = numOfPoints;
        this.counterForFirstPosition = counterForFirstPosition;
        this.counterForSecondPosition = counterForSecondPosition;
        this.counterForThirdPosition = counterForThirdPosition;
        this.counterForPoints = counterForPoints;
        this.counterForRacesPlayed=counterForRacesPlayed;
        this.counterForPosition=counterForPosition;
        this.counterForStartPosition=counterForStartPosition;
        this.probability=probability;
        this.date=date;

    }

    public int getNumOfFirstPosition() {
        return numOfFirstPosition;
    }

    public void setNumOfFirstPosition(int numOfFirstPosition) {
        this.numOfFirstPosition = numOfFirstPosition;
    }

    public int getNumOfSecondPosition() {
        return numOfSecondPosition;
    }

    public void setNumOfSecondPosition(int numOfSecondPosition) {
        this.numOfSecondPosition = numOfSecondPosition;
    }

    public int getNumOfThirdPosition() {
        return numOfThirdPosition;
    }

    public void setNumOfThirdPosition(int numOfThirdPosition) {
        this.numOfThirdPosition = numOfThirdPosition;
    }

    public int getNumOfRaces() { return numOfRaces; }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public void setNumOfPoints(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public int getCounterForFirstPosition() {
        return counterForFirstPosition;
    }

    public void setCounterForFirstPosition(int counterForFirstPosition) {
        this.counterForFirstPosition = counterForFirstPosition;
    }

    public int getCounterForSecondPosition() {
        return counterForSecondPosition;
    }

    public void setCounterForSecondPosition(int counterForSecondPosition) {
        this.counterForSecondPosition = counterForSecondPosition;
    }

    public int getCounterForThirdPosition() {
        return counterForThirdPosition;
    }

    public void setCounterForThirdPosition(int counterForThirdPosition) {
        this.counterForThirdPosition = counterForThirdPosition;
    }

    public int getCounterForPoints() {
        return counterForPoints;
    }

    public void setCounterForPoints(int counterForPoints) {
        this.counterForPoints = counterForPoints;
    }

    public int getCounterForRacesPlayed() {
        return counterForRacesPlayed;
    }

    public void setCounterForRacesPlayed(int counterForRacesPlayed) {
        this.counterForRacesPlayed = counterForRacesPlayed;
    }

    public int getCounterForPosition() {
        return counterForPosition;
    }

    public void setCounterForPosition(int counterForPosition) {
        this.counterForPosition = counterForPosition;
    }

    public int getCounterForStartPosition() {
        return counterForStartPosition;
    }

    public void setCounterForStartPosition(int counterForStartPosition) {
        this.counterForStartPosition = counterForStartPosition;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



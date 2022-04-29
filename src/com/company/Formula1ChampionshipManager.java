package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {
    static ArrayList<Formula1Driver> driverList = new ArrayList<>();//arraylist for the driver's name to be added to the system

    private final File tableDetails = new File("table.txt");
    static AddRaces addRaces = new AddRaces();//calling the addRace class
    static Scanner userInput = new Scanner(System.in);


    //===============================================================================================================================================================================
    @Override
    public void methodForAddDriverToSystem(Formula1Driver formula1Driver) {//addDriverToSystem method to add a driver to the system
        driverList.add(formula1Driver);//adding the driver to the arraylist
        System.out.println("|==================================================================================================|");
        System.out.println("|                   ******* A New Driver is Added Successfully *******                             |");
        System.out.println("|==================================================================================================|");
        System.out.println("                    ******* Welcome \""+formula1Driver.getNameOfTheDriver()+"\" to Formula1 Championship*******");
        System.out.println("|==================================================================================================|");
        System.out.println("");

        }


    //===============================================================================================================================================================================
    @Override
    public void methodForDeleteDriverFromSystem(String removeDriver) {//deleteDriver method to delete a driver from the system

            for (int i = 0; i < driverList.size(); i++) {
                if (driverList.get(i).getNameOfTheDriver().equals(removeDriver)) {//if the attributes of the driverList arraylist are equal to removeDriver it will display as mentioned below
                    System.out.println("|==================================================================================================|");
                    System.out.println("|               ******* The Driver was deleted from the system successfully *******                |");
                    System.out.println("|==================================================================================================|");
                    driverList.remove(i);//added driver names will removed from the system

                    break;
                }
            }
    }


    //===============================================================================================================================================================================
    @Override
    public void methodForChangeDriverFromATeam() {//methodForChangeDriverFromATeam method to swap a driver
        System.out.print("Enter Driver's Name (That You Need To Change The Team) : ");
        String driverInput = userInput.next();
        while (true) {
            String sameName = "none";
            for (Formula1Driver formula1driver : Formula1ChampionshipManager.driverList) {
                if (formula1driver.getNameOfTheDriver().equals(driverInput)) {
                    sameName = "repeated_name";
                    break;
                }
            }
            if (sameName.equals("repeated_name")) {
                System.out.println("Enter Driver's current team name: ");
                String changingTeam = userInput.next();

                for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {
                    if (changingTeam.equals(formula1Driver.getTeamOfTheDriver())) {
                        System.out.println("Enter driver's new team: ");
                        String newConstructorTeam = userInput.next();

                        if (!newConstructorTeam.equals(formula1Driver.getTeamOfTheDriver())) {
                            System.out.println("Already a driver is registered with the name you added");
                            System.out.println("Re enter a another name : ");
                            newConstructorTeam = userInput.next();

                        }
                        formula1Driver.setTeamOfTheDriver(newConstructorTeam);
                        System.out.println(driverInput + " 's Team has been changed to " + newConstructorTeam);


                    }
                }

            }
            break;
        }

    }

    //============================================================================================================================================================================
    @Override
    public void methodForDisplayFormulaTable() {//methodForDisplayFormulaTable to display the formula table
        String alignTable = "| %-12.5s  | %-14s | %-15s      | %-12.5s  | %-12.5s  | %-12.5s  | %-12.5s | %-12.5s | %n";//alignment

        System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");
        System.out.printf("| Driver's Name | Driver Team    | Driver's Location    | No.of 1st Pos | No.of 2nd Pos | No.of 3rd Pos | No.of Races  | Points       |%n");
        System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");
        driverList.sort(new ComparatorClass());//calling the comparator class to get sorted
        for (Formula1Driver formula1Driver : driverList) {
            System.out.format(alignTable, formula1Driver.getNameOfTheDriver(), formula1Driver.getTeamOfTheDriver(), formula1Driver.getLocationOfTheDriver(),
                    formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(), formula1Driver.getNumOfThirdPosition(),
                    formula1Driver.getNumOfRaces(), formula1Driver.getNumOfPoints());
        }

        System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");


    }



    //===============================================================================================================================================================================
    @Override

    public void methodForStaticticsOfDriver(String driverStatictics) {//methodForStaticticsOfDriver to display the formula drivers statictics

         for (Formula1Driver formula1Driver : driverList) {
            if (formula1Driver.getNameOfTheDriver().equals(driverStatictics)) {
                String alignTable = "| %-12.5s  | %-14s | %-15s      | %-12.5s  | %-12.5s  | %-12.5s  | %-12.5s | %-12.5s | %n";

                System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");
                System.out.printf("| Driver's Name | Driver Team    | Driver's Location    | No.of 1st Pos | No.of 2nd Pos | No.of 3rd Pos | No.of Races  | Points       |%n");
                System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");

                System.out.format(alignTable, formula1Driver.getNameOfTheDriver(), formula1Driver.getTeamOfTheDriver(), formula1Driver.getLocationOfTheDriver(),
                        formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(), formula1Driver.getNumOfThirdPosition(),
                        formula1Driver.getNumOfRaces(), formula1Driver.getNumOfPoints());
            }
        }
        System.out.printf("|===============|================|======================|===============|===============|===============|==============|==============|%n");


    }


    //===============================================================================================================================================================================
    @Override
    public void methodForAddARaceManual() {//methodForAddARaceManual to add races manually
        for (Formula1Driver formula1driver : driverList) {

            for (int i = 0; i < driverList.size(); i++) {
                System.out.print("Enter " + formula1driver.getNameOfTheDriver() + "'s Position:");
                break;

            }

            int optionForThePosition = userInput.nextInt();//user can add ten positions for the drivers
            switch (optionForThePosition) {
                case 1://if the position is equal to one it will store the position as one in the table
                    formula1driver.setCounterForFirstPosition(1);
                    addRaces.setFirstPosition(formula1driver.getNumOfFirstPosition() + formula1driver.getCounterForFirstPosition());
                    formula1driver.setNumOfFirstPosition(addRaces.getFirstPosition());

                    formula1driver.setCounterForPoints(25);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;
                case 2://if the position is equal to two it will store the position as one in the table
                    formula1driver.setCounterForSecondPosition(1);
                    addRaces.setSecondPosition(formula1driver.getNumOfSecondPosition() + formula1driver.getCounterForSecondPosition());
                    formula1driver.setNumOfSecondPosition(addRaces.getSecondPosition());

                    formula1driver.setCounterForPoints(18);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 3://if the position is equal to three it will store the position as one in the table
                    formula1driver.setCounterForThirdPosition(1);
                    addRaces.setThirdPosition(formula1driver.getNumOfThirdPosition() + formula1driver.getCounterForThirdPosition());
                    formula1driver.setNumOfThirdPosition(addRaces.getThirdPosition());

                    formula1driver.setCounterForPoints(15);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 4:
                    formula1driver.setCounterForPoints(12);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 5:
                    formula1driver.setCounterForPoints(10);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 6:
                    formula1driver.setCounterForPoints(8);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 7:
                    formula1driver.setCounterForPoints(6);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 8:
                    formula1driver.setCounterForPoints(4);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 9:
                    formula1driver.setCounterForPoints(2);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 10:
                    formula1driver.setCounterForPoints(1);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;

                default:
                    System.out.println("You Entered Position Wasn't Found");
                    break;

            }
            System.out.println("The positions for " + formula1driver.getNameOfTheDriver() + " is " + optionForThePosition);
        }

    }
    //===============================================================================================================================================================================

    @Override
    public void methodForSaveDataToTheFile() {//details are stored in a txt file
        try {
            File tableDetails = new File("table.txt");//stores the details in txt file
            tableDetails.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectOutputStream detailStore = new ObjectOutputStream(new FileOutputStream(tableDetails));
                if (driverList.size() == 0) {//if any drivers arent there in the system it will display as mentioned below
                    System.out.println("             |-------------------------------------------------------------------------------------|               ");
                    System.out.println("|------------|                      No Drivers Been Stored In The System                           |--------------|");
                    System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
                    System.out.println("");
                } else {//else the details will be stored successfully
                    detailStore.writeObject(driverList);
                    System.out.println("             |-------------------------------------------------------------------------------------|               ");
                    System.out.println("|------------|                  The Details You Added Have Been Stored Successfully                |--------------|");
                    System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
                    System.out.println("");
                }
                detailStore.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //===============================================================================================================================================================================
    @Override
    public void methodForRecover() throws FileNotFoundException {//recover the details that user saved in the txt file
        try {
            File file = new File("table.txt");//recover the details from the saved txt file
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectInputStream recoverData = new ObjectInputStream(new FileInputStream(tableDetails));
                driverList = (ArrayList<Formula1Driver>) recoverData.readObject();
                recoverData.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.print("");
            }
        }
    }
    //===============================================================================================================================================================================
    @Override
    public void methodForAddARaceAuto() {//methodForAddARaceAuto to add races automatically

        int yearGenerate = (int) (Math.random() * (2050 - 2020)) + 2020;//automatically adds a year
        int monthGenerate = (int) (Math.random() * (12 - 1)) + 1;//automatically adds a month
        int dayGenerate = (int) (Math.random() * (31 - 1)) + 1;//automatically adds a date
        System.out.println("Match held on : " + yearGenerate + "/" + monthGenerate + "/" + dayGenerate);
        String dateOfTheRace=(yearGenerate+"-"+monthGenerate+"-"+dayGenerate);

        for (Formula1Driver formula1driver : driverList) {
            formula1driver.setDate(String.valueOf(dateOfTheRace));

            int optionForThePosition = (int) (Math.random() * (10 - 1)) + 1;//this will auto generate the drivers position

            switch (optionForThePosition) {
                case 1://if the position is equal to one it will store the position as one in the table
                    formula1driver.setCounterForFirstPosition(1);
                    addRaces.setFirstPosition(formula1driver.getNumOfFirstPosition() + formula1driver.getCounterForFirstPosition());
                    formula1driver.setNumOfFirstPosition(addRaces.getFirstPosition());

                    formula1driver.setCounterForPoints(25);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;
                case 2://if the position is equal to two it will store the position as one in the table
                    formula1driver.setCounterForSecondPosition(1);
                    addRaces.setSecondPosition(formula1driver.getNumOfSecondPosition() + formula1driver.getCounterForSecondPosition());
                    formula1driver.setNumOfSecondPosition(addRaces.getSecondPosition());

                    formula1driver.setCounterForPoints(18);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 3://if the position is equal to three it will store the position as one in the table
                    formula1driver.setCounterForThirdPosition(1);
                    addRaces.setThirdPosition(formula1driver.getNumOfThirdPosition() + formula1driver.getCounterForThirdPosition());
                    formula1driver.setNumOfThirdPosition(addRaces.getThirdPosition());

                    formula1driver.setCounterForPoints(15);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 4:
                    formula1driver.setCounterForPoints(12);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 5:
                    formula1driver.setCounterForPoints(10);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 6:
                    formula1driver.setCounterForPoints(8);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 7:
                    formula1driver.setCounterForPoints(6);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 8:
                    formula1driver.setCounterForPoints(4);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 9:
                    formula1driver.setCounterForPoints(2);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;


                case 10:
                    formula1driver.setCounterForPoints(1);
                    addRaces.setPts(formula1driver.getNumOfPoints() + formula1driver.getCounterForPoints());
                    formula1driver.setNumOfPoints(addRaces.getPts());

                    formula1driver.setCounterForRacesPlayed(1);
                    addRaces.setRacesPlayed(formula1driver.getNumOfRaces() + formula1driver.getCounterForRacesPlayed());
                    formula1driver.setNumOfRaces(addRaces.getRacesPlayed());
                    break;

                default:
                    System.out.println("You Entered Position Wasn't Found");
                    break;

            }
            System.out.println("The positions for " + formula1driver.getNameOfTheDriver() + " is " + optionForThePosition);
        }
    }
    //===============================================================================================================================================================================
    @Override
    public void methodForAutoGenerate() {


        for (Formula1Driver formula1driver : driverList) {
            int option = (int) (Math.random() * (10 - 1)) + 1;//automatically generates race positions
            formula1driver.setCounterForStartPosition(option);
            switch (option) {
                case 1://if starting position equals to one, probability displays as 40%
                    formula1driver.setProbability("40%");
                    formula1driver.setCounterForPosition(1);
                    break;
                case 2://if starting position equals to two, probability displays as 30%
                    formula1driver.setProbability("30%");
                    formula1driver.setCounterForPosition(2);
                    break;
                case 3://if starting position equals to three, probability displays as 10%
                    formula1driver.setProbability("10%");
                    formula1driver.setCounterForPosition(3);
                    break;
                case 4://if starting position equals to four, probability displays as 10%
                    formula1driver.setProbability("10%");
                    formula1driver.setCounterForPosition(4);
                    break;
                case 5://if starting position equals to five, probability displays as 2%
                    formula1driver.setProbability("2%");
                    formula1driver.setCounterForPosition(5);
                    break;
                case 6://if starting position equals to six, probability displays as 2%
                    formula1driver.setProbability("2%");
                    formula1driver.setCounterForPosition(6);
                    break;
                case 7://if starting position equals to seven, probability displays as 2%
                    formula1driver.setProbability("2%");
                    formula1driver.setCounterForPosition(7);
                    break;
                case 8://if starting position equals to eight, probability displays as 2%
                    formula1driver.setProbability("2%");
                    formula1driver.setCounterForPosition(8);
                    break;
                case 9://if starting position equals to nine, probability displays as 2%
                    formula1driver.setProbability("2%");
                    formula1driver.setCounterForPosition(9);
                    break;
                case 10://if starting position equals to ten, probability displays as 0%
                    formula1driver.setProbability("0%");
                    formula1driver.setCounterForPosition(10);
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}





package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import static com.company.Formula1ChampionshipManager.driverList;

public class Formula1Menu {
    static Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();


    static Scanner input = new Scanner(System.in);


    public void menu() {
        while (true) {
            System.out.println("");
            System.out.println("              ====================================================================               ");
            System.out.println("|=============|                  WELCOME TO FORMULA1 CHAMPIONSHIP                |===============|");
            System.out.println("|===========@@@@@==============================================================@@@@@=============|");
            System.out.println("|---------------------  1 or A       : Add A New Driver To The System        --------------------|");
            System.out.println("|---------------------  2 or B       : Delete A Driver From The System       --------------------|");
            System.out.println("|---------------------  3 or C       : Swap The Driver's Team                --------------------|");
            System.out.println("|---------------------  4 or D       : Check Statictics Of A Driver          --------------------|");
            System.out.println("|---------------------  5 or E       : Display Entire Table                  --------------------|");
            System.out.println("|---------------------  6 or F       : Add A Race Played (Manual)            --------------------|");
            System.out.println("|---------------------  7 or G       : Add A Race Played (Auto)              --------------------|");
            System.out.println("|---------------------  8 or H       : Save All Entered Details              --------------------|");
            System.out.println("|---------------------  9 or I       : Open Gui Interface                    --------------------|");
            System.out.println("|---------------------  10 or J      : Exit The Program                      --------------------|");
            System.out.println("|================================================================================================|");
            System.out.println("");


            System.out.print("Enter a number to perform : ");

            switch (input.next()) {
                case "1":
                case "A":
                    addDriver();//calls the add driver method
                    break;

                case "2":
                case "B":
                    deleteDriver();//calls the delete driver method
                    break;

                case "3":
                case "C":
                    teamChanger();//calls the team swap method
                    break;

                case "4":
                case "D":
                    statsOfTheDriver();//calls the stats of the driver method
                    break;

                case "5":
                case "E":
                    displayTable();//calls the display table method
                    break;

                case "6":
                case "F":
                    addARaceOption();//calls the add race method
                    break;

                case "7":
                case "G":
                     formula1ChampionshipManager.methodForAddARaceAuto();//calls the add race method
                    break;

                case "8":
                case "H":
                    save();//calls the saving method
                    break;

                case "9":
                case "I":
                    guiMainInterface();//calls the gui interface method
                    break;

                case "10":
                case "J":
                    exitProgram();//calls the add exit method
                    break;

            }

        }

    }

    //=============================================================================================================================================================================
    private void addDriver() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                             Add A Driver To The System                              |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        System.out.print("Enter Driver's Name : ");
        String fDriverName = input.next();//user input for the driver's name
        while (true) {
            if (!fDriverName.matches("[a-zA-Z\\s]+")) {//if the user input was a integer for the driver name it will display as mentioned below
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.println("Re enter driver's Name : ");//again it will ask a user input
                fDriverName = input.next();
            } else {
                break;
            }
        }
        System.out.print("Enter Driver's team Name : ");//user input for the driver's team name
        String fTeamName = input.next();
        while (true) {

            String similarDriverName = "displayNone";//similar driver is equal to none when its empty
            for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {
                if (formula1Driver.getTeamOfTheDriver().equals(fTeamName)) {//if user entered similar names it will be founded as same
                    similarDriverName = "foundTheSameName";
                    break;
                }
            }
            if (similarDriverName.equals("foundTheSameName")) {//if user inputs are same as a name it will display as mentioned below
                System.out.println("Sorry!!!, There is already a driver registered to this team ");
                System.out.println("Re enter a another team name : ");//again it will ask a user input
                fTeamName = input.next();
            } else if (!fTeamName.matches("[a-zA-Z\\s]+")) {//if the user input was a integer for the driver team it will display as mentioned below
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.println("Re enter Driver's Team Name : ");//again it will ask a user input
                fTeamName = input.next();
            } else {
                break;
            }

        }
        System.out.print("Enter Driver's Location : ");//user input for the driver's location
        String fDriverLocation = input.next();
        while (true) {
            if (!fDriverLocation.matches("[a-zA-Z\\s]+")) {//if the user input was a integer for the driver location it will display as mentioned below
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.println("Re enter Driver's Location : ");//again it will ask a user input
                fDriverLocation = input.next();
            } else {
                break;
            }

        }
        Formula1Driver formulaObject = new Formula1Driver(fDriverName, fDriverLocation, fTeamName);//creating a object for the fDriverName and fDriverLocation and fTeamName and calling the method addDriverToSystem
        formula1ChampionshipManager.methodForAddDriverToSystem(formulaObject);

    }

    //=============================================================================================================================================================================
    private void deleteDriver() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                          Delete A Driver From The System                            |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        System.out.print("Enter Driver's name that you need to delete : ");
        String removeFDriver = input.next();//user input for remove the driver
        while (true) {
            String similarDriverName = "displayNone";//similar driver is equal to none when its empty
            for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {
                if (formula1Driver.getNameOfTheDriver().equals(removeFDriver)) {//if user entered similar names it will be founded as same
                    similarDriverName = "foundTheSameName";
                    break;
                }
            }
            if (!similarDriverName.equals("foundTheSameName")) {//if the inputs are same it will display as mentioned below
                System.out.println("There are no drivers registered");
                System.out.println("Re enter driver's name : ");
                removeFDriver = input.next();
            } else if (!removeFDriver.matches("[a-zA-Z\\s]+")) {
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.print("Re enter driver's name : ");
                removeFDriver = input.next();
            } else {
                break;
            }
        }
        formula1ChampionshipManager.methodForDeleteDriverFromSystem(removeFDriver);//calling the method deleteDriverFromSystem
    }

    //=============================================================================================================================================================================
    private void statsOfTheDriver() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                             Statictics Of The Driver                                |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        System.out.print("Enter Driver's Name : ");
        String fDriverStatName = input.next();//user input for the driver's name
        System.out.println("Statictics Of The Driver");
        while (true) {
            String similarDriverName = "displayNone";//similar driver is equal to none when its empty
            for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {
                if (formula1Driver.getNameOfTheDriver().equals(fDriverStatName)) {//if user entered similar names it will be founded as same
                    similarDriverName = "foundTheSameName";
                    break;
                }
            }
            if (!similarDriverName.equals("foundTheSameName")) {//if user inputs are same as a name it will display as mentioned below
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.println("Re enter Driver's name : ");//again it will ask a user input
                fDriverStatName = input.next();
            } else if (!fDriverStatName.matches("[a-zA-Z\\s]+")) {//if the user input was a integer for the driver name it will display as mentioned below
                System.out.println("|===============================================================================================================|");
                System.out.println("|                                    ****** Invalid input ******                                                |");
                System.out.println("|===============================================================================================================|");
                System.out.println("Re enter driver's Name : ");//again it will ask a user input
                fDriverStatName = input.next();
            } else {
                break;
            }


        }
        formula1ChampionshipManager.methodForStaticticsOfDriver(fDriverStatName);
    }

    //==============================================================================================================================================================================
    private void displayTable() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                                  Formula1 Table                                     |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        formula1ChampionshipManager.methodForDisplayFormulaTable();
    }

    //==============================================================================================================================================================================
    private void teamChanger() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                                  Swap The Team                                      |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        formula1ChampionshipManager.methodForChangeDriverFromATeam();
    }
    //=============================================================================================================================================================================
    private void addARaceOption() {
        System.out.println("             |-------------------------------------------------------------------------------------|               ");
        System.out.println("|------------|                                   Add A Race                                        |--------------|");
        System.out.println("|---------@@@@@@----------------------------------------------------------------------------------@@@@@@----------|");
        System.out.println("");
        System.out.print("Enter Race Date ( dd-mm-yyyy ) : ");
        String fRaceDate = input.next();//user input for the date
        while (true) {
            SimpleDateFormat correctDate = new SimpleDateFormat("dd-MM-yyyy");//date format
            try {
                correctDate.parse(fRaceDate);
                formula1ChampionshipManager.methodForAddARaceManual();
                for (Formula1Driver formula1Driver: driverList){
                    formula1Driver.setDate(fRaceDate);
                }
                break;
            } catch (Exception e) {
                System.out.println("------------   You entered date was invalid!!!   -------------- ");//if the date input wasn't as mentioned it will display as this
                System.out.print("Please re enter date in format (dd-MM-yyyy) : "); // ask the user input again
                fRaceDate = input.next();
            }


        }
        System.out.println("The race held on : " + fRaceDate);

    }

    //=============================================================================================================================================================================

    private void save() {

        formula1ChampionshipManager.methodForSaveDataToTheFile();
    }
    //=============================================================================================================================================================================

    private void guiMainInterface(){//main gui interface

        JFrame mainFrame=new JFrame();//creating jFrame
        mainFrame.setTitle("FORMULA1 MENU ");//title
        JLabel guiHeading=new JLabel("WELCOME TO FORMULA1 CHAMPIONSHIP");//label to display the heading
        mainFrame.add(guiHeading);
        guiHeading.setForeground(Color.white);
        guiHeading.setFont(guiHeading.getFont().deriveFont(30f));
        guiHeading.setBounds(500,20,700,50);

        JLabel guiQuote=new JLabel("<html><div style='text-align: center;'>Always Believed That<br> You Should Never, Ever Give Up  <br>" +
                "And You Should Always Keep Fighting<br> Even When There's Only A Slightest Chance" +
                "</html>",SwingConstants.CENTER);//quote that added in the main interface
        mainFrame.add(guiQuote);
        guiQuote.setOpaque(true);
        Color hh=new Color(0,0,0,150);
        guiQuote.setBackground(hh);
        guiQuote.setForeground(Color.white);
        guiQuote.setFont(new Font("Rajdhani", Font.PLAIN, 30));

        guiQuote.setBounds(600,270,800,300);


        JButton btnOne=new JButton("View Table (Ascending Order)");//button for view table (ascending order)
        btnOne.setBounds(100,150,400,50);
        btnOne.setForeground(Color.white);
        btnOne.setBackground(Color.black);
        btnOne.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnOne.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnOne.getBorder().getBorderInsets(btnOne).top,
                        btnOne.getBorder().getBorderInsets(btnOne).left,
                        btnOne.getBorder().getBorderInsets(btnOne).bottom,
                        btnOne.getBorder().getBorderInsets(btnOne).right)));
        mainFrame.add(btnOne);



        JButton btnTwo=new JButton("View Table (Descending Order)");//button for view table (descending order)
        btnTwo.setBounds(100,220,400,50);
        btnTwo.setForeground(Color.white);
        btnTwo.setBackground(Color.black);
        btnTwo.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnTwo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnTwo.getBorder().getBorderInsets(btnTwo).top,
                        btnTwo.getBorder().getBorderInsets(btnTwo).left,
                        btnTwo.getBorder().getBorderInsets(btnTwo).bottom,
                        btnTwo.getBorder().getBorderInsets(btnTwo).right)));
        mainFrame.add(btnTwo);



        JButton btnAddRace=new JButton("Click Here To Add Races");//button for add races automatically
        btnAddRace.setBounds(100,290,400,50);
        btnAddRace.setForeground(Color.white);
        btnAddRace.setBackground(Color.black);
        btnAddRace.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnAddRace.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnAddRace.getBorder().getBorderInsets(btnAddRace).top,
                        btnAddRace.getBorder().getBorderInsets(btnAddRace).left,
                        btnAddRace.getBorder().getBorderInsets(btnAddRace).bottom,
                        btnAddRace.getBorder().getBorderInsets(btnAddRace).right)));
        mainFrame.add(btnAddRace);



        JButton btnProb=new JButton("View Table (Probability)");//button for view table (ascending order)
        btnProb.setBounds(100,360,400,50);
        btnProb.setForeground(Color.white);
        btnProb.setBackground(Color.black);
        btnProb.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnProb.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnProb.getBorder().getBorderInsets(btnProb).top,
                        btnProb.getBorder().getBorderInsets(btnProb).left,
                        btnProb.getBorder().getBorderInsets(btnProb).bottom,
                        btnProb.getBorder().getBorderInsets(btnProb).right)));
        mainFrame.add(btnProb);


        JButton btnSearch=new JButton("Search For A Driver");//button for search a driver
        btnSearch.setBounds(100,430,400,50);
        btnSearch.setForeground(Color.white);
        btnSearch.setBackground(Color.black);
        btnSearch.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnSearch.getBorder().getBorderInsets(btnSearch).top,
                        btnSearch.getBorder().getBorderInsets(btnSearch).left,
                        btnSearch.getBorder().getBorderInsets(btnSearch).bottom,
                        btnSearch.getBorder().getBorderInsets(btnSearch).right)));
        mainFrame.add(btnSearch);


        JButton btnDate=new JButton("View Table (With Date Sorted)");//button for view table (with date sorted)
        btnDate.setBounds(100,500,400,50);
        btnDate.setForeground(Color.white);
        btnDate.setBackground(Color.black);
        btnDate.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnDate.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnDate.getBorder().getBorderInsets(btnDate).top,
                        btnDate.getBorder().getBorderInsets(btnDate).left,
                        btnDate.getBorder().getBorderInsets(btnDate).bottom,
                        btnDate.getBorder().getBorderInsets(btnDate).right)));
        mainFrame.add(btnDate);


        JButton btnReturn=new JButton("Return To Main Menu");//button to return to the main menu
        btnReturn.setBounds(100,570,400,50);
        btnReturn.setForeground(Color.white);
        btnReturn.setBackground(Color.black);
        btnReturn.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnReturn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnReturn.getBorder().getBorderInsets(btnReturn).top,
                        btnReturn.getBorder().getBorderInsets(btnReturn).left,
                        btnReturn.getBorder().getBorderInsets(btnReturn).bottom,
                        btnReturn.getBorder().getBorderInsets(btnReturn).right)));
        mainFrame.add(btnReturn);


        JButton btnExit=new JButton("Exit");//button to exit the program
        btnExit.setBounds(100,640,400,50);
        btnExit.setForeground(Color.white);
        btnExit.setBackground(Color.black);
        btnExit.setFont(new Font("Rajdhani", Font.PLAIN, 15));
        btnExit.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(
                        btnExit.getBorder().getBorderInsets(btnExit).top,
                        btnExit.getBorder().getBorderInsets(btnExit).left,
                        btnExit.getBorder().getBorderInsets(btnExit).bottom,
                        btnExit.getBorder().getBorderInsets(btnExit).right)));
        mainFrame.add(btnExit);


        btnTwo.addActionListener(new ActionListener() {//if user clicks the descending order button it take the user to a new interface and displays the table with descending order
            @Override
            public void actionPerformed(ActionEvent e) {
                descendingGuiInterface();
                mainFrame.setVisible(false);
            }
        });

        btnOne.addActionListener(new ActionListener() {//if user clicks the ascending order button it take the user to a new interface and displays the table with ascending order
            @Override
            public void actionPerformed(ActionEvent e) {
                ascendingGuiInterface();
                mainFrame.setVisible(false);
            }
        });

        btnAddRace.addActionListener(new ActionListener() {//if user clicks the add race button it will add races automatically
            @Override
            public void actionPerformed(ActionEvent e) {

                formula1ChampionshipManager.methodForAddARaceAuto();
            }
        });

        btnExit.addActionListener(new ActionListener() {//if user clicks the exit button it will exit the program
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        btnProb.addActionListener(new ActionListener() {//if user clicks the probability button it take the user to a new interface and displays the table with probability
            @Override
            public void actionPerformed(ActionEvent e) {
                probabilityGuiInterface();

                mainFrame.setVisible(false);
            }
        });
        btnSearch.addActionListener(new ActionListener() {//if user clicks the search driver button it take the user will take the user to a new interface
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTable();

                mainFrame.setVisible(false);
            }
        });
        btnDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dateDisplay();
                mainFrame.setVisible(false);
            }
        });
        btnReturn.addActionListener(new ActionListener() {//if user clicks the return button it will take the user to the main menu
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
            }
        });


        ImageIcon car=new ImageIcon("C:\\Users\\hp\\Desktop\\OOP CW\\w1832563\\w1832563_Formula1_CW\\gg.jpg");//image for the background of the interface
        JLabel label=new JLabel("",car,JLabel.CENTER);
        mainFrame.add(new JScrollPane());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(screenSize.width, screenSize.height);
        mainFrame.add(label);
        mainFrame.setSize(2000, 1000 );
        mainFrame.setVisible(true);
    }


    private void descendingGuiInterface() {//interface to displays the table with descending order
        JFrame desFrame=new JFrame();
        desFrame.setTitle("FORMULA1 TABLE (DESCENDING ORDER) ");//title
        JPanel panel =new JPanel(new BorderLayout());

        JLabel headingLabel=new JLabel("<html>\n\n\n\n\n\n\n <br>   FORMULA1 CHAMPIONSHIP TABLE (DESCENDING ORDER)     <br> <br></html>",SwingConstants.CENTER);
        headingLabel.setFont(headingLabel.getFont().deriveFont(20f));
        panel.add(headingLabel,BorderLayout.CENTER)  ;


        Color n = new Color(255, 255, 208);//background color
        panel.setBackground(n);
        desFrame.add(panel,BorderLayout.NORTH);

        JButton btnBack=new JButton("Back");
        btnBack.setBounds(1200,700,100,40);
        desFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {//button to display the previous interface
            @Override
            public void actionPerformed(ActionEvent e) {
                guiMainInterface();
                desFrame.setVisible(false);
            }
        });
        JButton btnExit=new JButton("Exit");//button to exit the program
        btnExit.setBounds(1350,700,100,40);
        desFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel newTable = new DefaultTableModel();
        JTable table = new JTable(newTable);//creating a table
        JScrollPane scrollPane=new JScrollPane(table);


        newTable.addColumn("Driver Name");//adding row to the table
        newTable.addColumn("Team Name");
        newTable.addColumn("Driver Location");
        newTable.addColumn("No of 1st Pos");
        newTable.addColumn("No of 2nd Pos");
        newTable.addColumn("No of 3rd Pos");
        newTable.addColumn("No of Races");
        newTable.addColumn("PTS");


        driverList.sort(new PointsComparator());
        for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {//rows to the table

            newTable.insertRow(0, new Object[]{formula1Driver.getNameOfTheDriver(),
                    formula1Driver.getTeamOfTheDriver(), formula1Driver.getLocationOfTheDriver(),
                    formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(),
                    formula1Driver.getNumOfThirdPosition(), formula1Driver.getNumOfRaces(),
                    formula1Driver.getNumOfPoints()});

        }
        table.setRowHeight(0, 40);//adding a height to the row of the table
        table.setRowHeight(1, 40);
        table.setRowHeight(2, 40);
        table.setRowHeight(3, 40);
        table.setRowHeight(4, 40);
        table.setRowHeight(5, 40);
        table.setRowHeight(6, 40);
        table.setRowHeight(7, 40);
        table.setRowHeight(8, 40);
        table.setRowHeight(9, 40);

        Color silver=new Color(211,211,211);
        table.setBackground(silver);
        Color butter = new Color(255, 255, 208);
        scrollPane.getViewport().setBackground(butter);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBorder(new EmptyBorder(0,0,0,0));



        desFrame.add(scrollPane);
        desFrame. setSize(2000, 1000);
        btnBack.setBackground(silver);//button color
        btnExit.setBackground(silver);
        desFrame.setVisible(true);
    }

    private void ascendingGuiInterface() {//interface to displays the table with ascending order
        JFrame ascFrame=new JFrame();
        ascFrame.setTitle("FORMULA1 TABLE (ASCENDING ORDER) ");//title
        JPanel panel =new JPanel(new BorderLayout());

        JLabel headingLabel=new JLabel("<html>\n\n\n\n\n\n\n <br>   FORMULA1 CHAMPIONSHIP TABLE (ASCENDING ORDER)     <br> <br></html>",SwingConstants.CENTER);
        headingLabel.setFont(headingLabel.getFont().deriveFont(20f));
        panel.add(headingLabel,BorderLayout.CENTER)  ;


        Color n = new Color(255, 255, 208);// background color
        panel.setBackground(n);
        ascFrame.add(panel,BorderLayout.NORTH);

        JButton btnBack=new JButton("Back");
        btnBack.setBounds(1200,700,100,40);
        ascFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiMainInterface();
                ascFrame.setVisible(false);
            }
        });
        JButton btnExit=new JButton("Exit");
        btnExit.setBounds(1350,700,100,40);
        ascFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel newTable = new DefaultTableModel();
        JTable table = new JTable(newTable);
        JScrollPane scrollPane=new JScrollPane(table);


        newTable.addColumn("Driver Name");
        newTable.addColumn("Team Name");
        newTable.addColumn("Driver Location");
        newTable.addColumn("No of 1st Pos");
        newTable.addColumn("No of 2nd Pos");
        newTable.addColumn("No of 3rd Pos");
        newTable.addColumn("No of Races");
        newTable.addColumn("PTS");


        driverList.sort(new ComparatorClass());
        for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {

            newTable.insertRow(0, new Object[]{formula1Driver.getNameOfTheDriver(),
                    formula1Driver.getTeamOfTheDriver(), formula1Driver.getLocationOfTheDriver(),
                    formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(),
                    formula1Driver.getNumOfThirdPosition(), formula1Driver.getNumOfRaces(),
                    formula1Driver.getNumOfPoints()});

        }
        table.setRowHeight(0, 40);
        table.setRowHeight(1, 40);
        table.setRowHeight(2, 40);
        table.setRowHeight(3, 40);
        table.setRowHeight(4, 40);
        table.setRowHeight(5, 40);
        table.setRowHeight(6, 40);
        table.setRowHeight(7, 40);
        table.setRowHeight(8, 40);
        table.setRowHeight(9, 40);

        Color silver=new Color(211,211,211);
        table.setBackground(silver);
        Color butter = new Color(255, 255, 208);
        scrollPane.getViewport().setBackground(butter);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBorder(new EmptyBorder(0,0,0,0));



        ascFrame.add(scrollPane);
        ascFrame. setSize(2000, 1000);
        btnBack.setBackground(silver);
        btnExit.setBackground(silver);
        ascFrame.setVisible(true);

    }

    private void probabilityGuiInterface() {
        formula1ChampionshipManager.methodForAutoGenerate();

        JFrame probFrame=new JFrame();
        probFrame.setTitle("FORMULA1 TABLE (PROBABILITY) ");//title
        JPanel panel =new JPanel(new BorderLayout());

        JLabel headingLabel=new JLabel("<html>\n\n\n\n\n\n\n <br>   FORMULA1 CHAMPIONSHIP TABLE (PROBABILITY)     <br> <br></html>",SwingConstants.CENTER);
        headingLabel.setFont(headingLabel.getFont().deriveFont(20f));
        panel.add(headingLabel,BorderLayout.CENTER)  ;


        Color n = new Color(255, 255, 208);
        panel.setBackground(n);
        probFrame.add(panel,BorderLayout.NORTH);

        JButton btnBack=new JButton("Back");
        btnBack.setBounds(1200,700,100,40);
        probFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiMainInterface();
                probFrame.setVisible(false);
            }
        });
        JButton btnExit=new JButton("Exit");
        btnExit.setBounds(1350,700,100,40);
        probFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel newTable = new DefaultTableModel();
        JTable table = new JTable(newTable);
        JScrollPane scrollPane=new JScrollPane(table);

        newTable.addColumn("Driver Name");
        newTable.addColumn("Team Name");
        newTable.addColumn("Driver Location");
        newTable.addColumn("Starting Pos");
        newTable.addColumn("Probability Of Winning");

        for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {

            newTable.insertRow(0, new Object[]{formula1Driver.getNameOfTheDriver(),formula1Driver.getTeamOfTheDriver(),
                    formula1Driver.getLocationOfTheDriver(),
                    formula1Driver.getCounterForStartPosition(), formula1Driver.getProbability(),
                 });

        }
        table.setRowHeight(0, 40);
        table.setRowHeight(1, 40);
        table.setRowHeight(2, 40);
        table.setRowHeight(3, 40);
        table.setRowHeight(4, 40);
        table.setRowHeight(5, 40);
        table.setRowHeight(6, 40);
        table.setRowHeight(7, 40);
        table.setRowHeight(8, 40);
        table.setRowHeight(9, 40);

        Color silver=new Color(211,211,211);
        table.setBackground(silver);
        Color butter = new Color(255, 255, 208);
        scrollPane.getViewport().setBackground(butter);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBorder(new EmptyBorder(0,0,0,0));



        probFrame.add(scrollPane);
        probFrame. setSize(2000, 1000);
        btnBack.setBackground(silver);
        btnExit.setBackground(silver);

        probFrame.setVisible(true);
    }
    private void searchTable() {
        JFrame searchFrame=new JFrame();
        searchFrame.setTitle("SEARCH FOR A DRIVER ");//title
        JButton btnBack=new JButton("Back");
        btnBack.setBounds(1200,700,100,40);
        searchFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiMainInterface();
                searchFrame.setVisible(false);
            }
        });
        JButton btnExit=new JButton("Exit");
        btnExit.setBounds(1350,700,100,40);
        searchFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel newTable = new DefaultTableModel();

        JTable table = new JTable(newTable);



        newTable.addColumn("Driver Name");
        newTable.addColumn("Team Name");
        newTable.addColumn("Driver Location");
        newTable.addColumn("No of 1st Pos");
        newTable.addColumn("No of 2nd Pos");
        newTable.addColumn("No of 3rd Pos");
        newTable.addColumn("No of Races");
        newTable.addColumn("Race held On");
        newTable.addColumn("PTS");



        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);


        driverList.sort(new ComparatorClass());                                                                                                                              // references :https://stackoverflow.com/
        for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {

            newTable.insertRow(0, new Object[]{formula1Driver.getNameOfTheDriver(),
                    formula1Driver.getLocationOfTheDriver(), formula1Driver.getTeamOfTheDriver(),
                    formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(),
                    formula1Driver.getNumOfThirdPosition(), formula1Driver.getNumOfRaces(),formula1Driver.getDate(),
                    formula1Driver.getNumOfPoints()});

        }




        searchFrame.add(new JScrollPane(table));

        final TableRowSorter<TableModel> searchSorter=new TableRowSorter<TableModel>(newTable);
        table.setRowSorter(searchSorter);
        JScrollPane pane =new JScrollPane(table);
        searchFrame.add(pane,BorderLayout.CENTER);

        JPanel panel =new JPanel(new BorderLayout());
        JLabel labelUser=new JLabel("Enter The Driver Name Or Driver Team : ");
        panel.add(labelUser,BorderLayout.WEST);
        Color silver=new Color(211,211,211);
        table.setBackground(silver);
        Color butter = new Color(255, 255, 208);
        pane.getViewport().setBackground(butter);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBorder(new EmptyBorder(0,0,0,0));


        final JTextField fltx=new JTextField("type here");
        panel.add(fltx,BorderLayout.CENTER);
        fltx.setBackground(butter);
        searchFrame.add(panel,BorderLayout.NORTH);
        JButton btnSearch=new JButton("Search");
        table.setVisible(false);

        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt=fltx.getText();
                if (txt.length()==0){
                    searchSorter.setRowFilter(null);

                }else {
                    searchSorter.setRowFilter(RowFilter.regexFilter(txt));
                    table.setVisible(true);
                }
            }
        });

        searchFrame.add(btnSearch,BorderLayout.SOUTH);
        btnBack.setBackground(silver);
        btnExit.setBackground(silver);
        searchFrame. setSize(2000, 830);

        searchFrame.setVisible(true);

    }
    private void dateDisplay() {//display the table with the date
        JFrame dateFrame=new JFrame();
        dateFrame.setTitle("FORMULA1 TABLE ");//title
        JPanel panel =new JPanel(new BorderLayout());

        JLabel headingLabel=new JLabel("<html>\n\n\n\n\n\n\n <br>   FORMULA1 CHAMPIONSHIP TABLE    <br> <br></html>",SwingConstants.CENTER);
        headingLabel.setFont(headingLabel.getFont().deriveFont(20f));
        panel.add(headingLabel,BorderLayout.CENTER)  ;


        Color n = new Color(255, 255, 208);//background color
        panel.setBackground(n);
        dateFrame.add(panel,BorderLayout.NORTH);

        JButton btnBack=new JButton("Back");
        btnBack.setBounds(1200,700,100,40);
        dateFrame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {//button to display the previous interface
            @Override
            public void actionPerformed(ActionEvent e) {
                guiMainInterface();
                dateFrame.setVisible(false);
            }
        });
        JButton btnExit=new JButton("Exit");//button to exit the program
        btnExit.setBounds(1350,700,100,40);
        dateFrame.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel newTable = new DefaultTableModel();
        JTable table = new JTable(newTable);//creating a table
        JScrollPane scrollPane=new JScrollPane(table);


        newTable.addColumn("Driver Name");//adding row to the table
        newTable.addColumn("Team Name");
        newTable.addColumn("Driver Location");
        newTable.addColumn("No of 1st Pos");
        newTable.addColumn("No of 2nd Pos");
        newTable.addColumn("No of 3rd Pos");
        newTable.addColumn("No of Races");
        newTable.addColumn("Race held On");
        newTable.addColumn("PTS");


        driverList.sort(new PointsComparator());
        for (Formula1Driver formula1Driver : Formula1ChampionshipManager.driverList) {//rows to the table

            newTable.insertRow(0, new Object[]{formula1Driver.getNameOfTheDriver(),
                    formula1Driver.getTeamOfTheDriver(), formula1Driver.getLocationOfTheDriver(),
                    formula1Driver.getNumOfFirstPosition(), formula1Driver.getNumOfSecondPosition(),
                    formula1Driver.getNumOfThirdPosition(), formula1Driver.getNumOfRaces(),formula1Driver.getDate(),
                    formula1Driver.getNumOfPoints()});

        }
        table.setRowHeight(0, 40);//adding a height to the row of the table
        table.setRowHeight(1, 40);
        table.setRowHeight(2, 40);
        table.setRowHeight(3, 40);
        table.setRowHeight(4, 40);
        table.setRowHeight(5, 40);
        table.setRowHeight(6, 40);
        table.setRowHeight(7, 40);
        table.setRowHeight(8, 40);
        table.setRowHeight(9, 40);

        Color silver=new Color(211,211,211);
        table.setBackground(silver);
        Color butter = new Color(255, 255, 208);
        scrollPane.getViewport().setBackground(butter);
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBorder(new EmptyBorder(0,0,0,0));



        dateFrame.add(scrollPane);
        dateFrame. setSize(2000, 1000);
        btnBack.setBackground(silver);//button color
        btnExit.setBackground(silver);
        dateFrame.setVisible(true);
    }

    //=============================================================================================================================================================================
    private void exitProgram() {//method to exit the program
        System.out.println("You have Exited the program");
        System.out.println("|=================================================================================================================================================|");
        System.out.println("|                                                  ****** Thank You  ******                                                                       |");
        System.out.println("|=================================================================================================================================================|");
        System.exit(0);

    }

}











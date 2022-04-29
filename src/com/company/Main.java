package com.company;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Formula1ChampionshipManager formulaObj= new Formula1ChampionshipManager();
        formulaObj.methodForRecover();
        Formula1Menu formula1Menu = new Formula1Menu();

        formula1Menu.menu();
    }
}


package com.company;


import java.io.FileNotFoundException;


public interface ChampionshipManager {
    void methodForAddDriverToSystem(Formula1Driver formula1Driver);
    void methodForDeleteDriverFromSystem(String removeDriver);
    void methodForChangeDriverFromATeam();
    void methodForDisplayFormulaTable();
    void methodForStaticticsOfDriver(String driverStatictics);
    void methodForAddARaceManual();
    void methodForAddARaceAuto();
    void methodForAutoGenerate();
    void methodForSaveDataToTheFile ();
    void methodForRecover() throws FileNotFoundException;




}

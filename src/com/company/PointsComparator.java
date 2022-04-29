package com.company;

import java.util.Comparator;

public class PointsComparator  implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver firstPosition, Formula1Driver secondPosition) {
        if (firstPosition.getNumOfPoints()>secondPosition.getNumOfPoints()){//the highest points scored comes on the top in the table
            return 1;
        }else if (secondPosition.getNumOfPoints()>firstPosition.getNumOfPoints()){
            return -1;
        }
        else {
            int firstOne = firstPosition.getCounterForFirstPosition(); //if the points are same, the highest first position difference comes on the top in the table
            int secondOne = secondPosition.getCounterForSecondPosition();
            if(firstOne > secondOne)
                return 1;
            else if(secondOne>firstOne)
                return -1;
            else {
                if (firstPosition.getCounterForRacesPlayed()<secondPosition.getCounterForRacesPlayed())//if the points are same, the lowest race played comes on the top in the table
                    return 1;
                else if(secondPosition.getCounterForRacesPlayed()<firstPosition.getCounterForRacesPlayed())
                    return -1;
                else
                    return 0;
            }
        }
    }

}

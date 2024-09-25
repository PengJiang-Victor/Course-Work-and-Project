package edu.nyu.cs;

import java.util.Scanner;

/**
 * This question is based on Question 1-11 in Liang's Intro to Java textbook.
 * 
 * Complete this program such that it:
 * - calculates and displays the projected population for each of the next five
 * years.
 *
 * The U.S. Census Bureau projects population based on the following
 * assumptions:
 * - Current population: 334,300,850
 * - Each year has 365 days
 * - One birth every 9 seconds
 * - One death every 10 seconds
 * - One new immigrant every 32 seconds
 * 
 * Hint:
 * - There are no fractional people. All population projections must be
 * integers.
 * - In Java, if two integers perform division, the result is an integer - the
 * fractional part is truncated.
 * - To get an accurate result, one of the values in the division must be a
 * number with a decimal place.
 * 
 * Sample output. Your program should format the output exactly like this:
 * Here are the projected population numbers for the next five years:
 * - Year 2024: 335636750
 * - Year 2025: 336972650
 * - Year 2026: 338308550
 * - Year 2027: 339644450
 * - Year 2028: 340980350
 */
public class PopulationProjector {

    /**
     * The main function is automatically called first in a Java program.
     * Complete the assignment within this function.
     * 
     * @param args An array of any command-line arguments. Java requires the main
     *             function include this, even if not used.
     * @throws Exception Allows us to not worry about Exceptions in this function.
     *                   Java requires the main functino include this, even if not
     *                   used.
     */
    public static void main(String[] args) throws Exception {
        
        int Currentpopulation = 334300850;
        int yearInSec = (365*24*60*60);
        double ChangeRateOfBirthPerSec = (1.0/9.0);
        double ChangeRateOfDeathPerSec = (1.0/10.0);
        double ChangeRateOfImmigrantPerSec = (1.0/32.0);//define a bunch of variables which I can directly use in the following calculation.
       
        double result1 = Currentpopulation+(ChangeRateOfBirthPerSec-ChangeRateOfDeathPerSec+ChangeRateOfImmigrantPerSec)*yearInSec;//the computation of population after one year
        int result1round = (int) Math.round (result1);
        

        double result2 = result1 + (ChangeRateOfBirthPerSec-ChangeRateOfDeathPerSec+ChangeRateOfImmigrantPerSec)*yearInSec;//the computation of population after two year
        int result2round = (int) Math.round (result2);


        double result3 = result2 + (ChangeRateOfBirthPerSec-ChangeRateOfDeathPerSec+ChangeRateOfImmigrantPerSec)*yearInSec;//the computation of population after three year
        int result3round = (int) Math.round (result3);


        double result4 = result3 + (ChangeRateOfBirthPerSec-ChangeRateOfDeathPerSec+ChangeRateOfImmigrantPerSec)*yearInSec;//the computation of population after four year
        int result4round = (int) Math.round (result4);


        double result5 = result4 + (ChangeRateOfBirthPerSec-ChangeRateOfDeathPerSec+ChangeRateOfImmigrantPerSec)*yearInSec;//the computation of population after five year
        int result5round = (int) Math.round (result5);

        System.out.println("Here are the projected population numbers for the next five years:");
        System.out.println("- Year 2024: "+ result1round);
        System.out.println("- Year 2025: "+ result2round);
        System.out.println("- Year 2026: "+ result3round);
        System.out.println("- Year 2027: "+ result4round);
        System.out.println("- Year 2028: "+ result5round);//output
                // complete this function to solve the problem
    }

}

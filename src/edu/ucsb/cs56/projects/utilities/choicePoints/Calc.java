package edu.ucsb.cs56.projects.utilities.choicePoints;

/** Calculator for BAC
    @author Dominic Kirby and Hernan Duran
    @version CS56 F16
*/

public final class Calc{

    //Constructor
    private Calc(){}
    
    /**
       Calculates the Blood Alcohol Content from the parameters
       given through the constructor
       @param isMale whether or not the user is male
       @param hours # of hours the user has been drinking
       @param weight the user's weight
       @param isKilograms whether or not the user specified
       their weight in kilograms
       @param beer number of beers drank
       @param wine glasses of wine drank
       @param hardLiquor number of hard liquor shots taken
       @return BAC Blood Alcohol Concentration for the specific inputted values
    */
    
    public static double BAC(
                             boolean isMale,
                             int hours,
                             int weight,
                             boolean isKilograms,
                             int beer,
			     double beerAlcoholContent,
                             int wine,
			     double wineAlchoholContent,
                             int hardLiquor,
			     double liqAlcoholContent){
        //assigns the proper gender distribution ratio according to the gender
        double genderDistRatio = isMale ? .73 : .66;


	//find liquid ounces of each alcohol consumed
	double liquidOuncesOfBeer = beer * 12 * beerAlcoholContent;
	double liquidOuncesOfWine = wine * 5 * wineAlchoholContent;
	double liquidOuncesOfLiquor = hardLiquor * 1.5 * liqAlcoholContent;

	
        //finds the number of liquid ounces of alcohol consumed by the person
        double liquidOunces = liquidOuncesOfBeer+liquidOuncesOfWine+liquidOuncesOfLiquor;
	
        //calculates the Blood Alcohol Concentration with the given values
        double bac = 0.0;
	if (weight < 0 || hours < 0){
	    return -1.0;
	}
	
        if(isKilograms){
	    bac = (liquidOunces*5.14)/
		((weight*2.2046)*genderDistRatio)-(hours*.015);
	}
        else{
	    bac = (liquidOunces*5.14)/
		(weight*genderDistRatio)-(hours*.015);
	}
	
        if(bac > 0){
	    return bac;
	}
        else if(bac > 1){
	    return 1.0;
	}
        else{
	    return 0.0;
	}
    }
}

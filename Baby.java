/**
 * Class Baby:
 *  The Baby class represents a Baby object with the following properties,
 *  in protected internal variables named:
 *      String _firstName,
 *      String _lastName,
 *      String _id (the id mumber),
 *      Date _dateOfBirth,
 *      Weight _birthWeight,
 *      Weight _currentWeight.
 *  
 *  The class has 2 constructors:
 *  - A constructor that allows to set the data of the baby by providing:
 *      first name, last name, id (up to 9 digits), day, month and year 
 *      of birth, weight at birth in grams.
 *      The constructor does not checks the validity of the date but it will be
 *      done by the constructor of the Date class, and if it is not a valid date
 *      it is set to 01/01/2024.
 *      The constructor does not checks the validity of weight but it will be
 *      done by the constructor of the Weight class, and if it is not a valid weight
 *      it is set to 1 kilo.
 *  - A constructor that copies a valid Baby object.
 *  
 *  The class has 6 retrieving methods to get the internal values of the Baby:
 *      String getFirstName(), String getLastName(), String getId(),
 *      Date getDateOfBirth(),
 *      Weight getBirthWeight(), Weight getCurrentWeight()
 *
 *  The class has 1 setting method to set the current weight of the baby:
 *      void setCurrentWeight(Weight weightToSet)
 *
 *  The class utilities methods:
 *  - A method to compare another baby to this object looking at 3 properties only:
 *          First and Last names and id
 *      boolean equals(Baby other)
 *  - A method to compare another baby to this object to check if they are twins by looking at
 *          3 properties only:
 *          Last names must be equal,
 *          First name and Id must not be equal,
 *          Date of birth must be within one day apart (0 or 1 day)
 *      boolean areTwins(Baby other)
 *  - A method to check if the weight of this baby is heavier than the weight of another baby.
 *      boolean heavier(Baby other)
 *  - A method to check if the date of birth of this baby is before than the date of birth of another baby.
 *      int older(Baby other)
 *  - A method to set the current weight of the baby, only if the grams to add are valid.
 *      void setCurrentWeight(Weight weightToSet)
 *  - A method to check if the current weight of this baby is within the valid range based on
 *      it's age, given by the parameter numOfDays, and it's current weight, and compared to
 *      standard medical accepted changes in baby weight during it's first year.
 *      int isWeightInValidRange(int numOfDays)
 *  - A method to get the object as a string in a formatted form
 *      String toString()
 *
 *  The class has 1 helper internal (private) methods:
 *  - A method to check that the id is a string of length 9 otherwise returns "000000000"
 *      String checkId(String id)
 *      
 * @author (Zvika Barak)
 * @ID (050982479)
 * @version (12.11.2024)
 */

import java.util.Scanner;

public class Baby
{
    // instance variables
    private String _firstName;
    private String _lastName;
    private String _id;
    private Date _dateOfBirth;
    private Weight _birthWeight;
    private Weight _currentWeight;
    /**
     * 2 Constructors for objects of class Baby
     */
    public Baby(String fName, String lName, String id,
    int day, int month, int year, int birthWeightInGrams)
    {
        // set the instance variables
        _firstName = fName;
        _lastName = lName;
        _id = checkId(id);   // need to verify 9 digits otherwise returns 9 zerםs
        // and if not valid set it to 9 zeros
        _dateOfBirth = new Date(day, month, year);
        _birthWeight = new Weight(birthWeightInGrams);
        _currentWeight = new Weight(_birthWeight);  // same as birth weight
    } // end of constructor Baby(String fName, String lName, String id,
    //        int day, int month, int year, int birthWeightInGrams)
    private String checkId(String id)
    {
        final String DEFAULT_ID = "000000000";
        final int VALID_ID_KENGTH = 9;
        if (id.length() == VALID_ID_KENGTH)
            return id;
        return DEFAULT_ID;
    }
    /**
     * Constructor to copy existing 'other' Baby object
     */
    public Baby(Baby other)
    {
        // initialise instance variables for the baby in the object 'other'
        _firstName = other._firstName;
        _lastName = other._lastName;
        _id = other._id;
        _dateOfBirth = new Date(other._dateOfBirth);
        _birthWeight = new Weight(other._birthWeight);
        _currentWeight = new Weight(other._currentWeight);
    }   // end of constructor Baby(Baby other)

    /**
     * 6 retrieving methods
     */
    public String getFirstName()    // gets the first Name
    {
        return _firstName;
    }

    public String getLastName()    // gets the last Name
    {
        return _lastName;
    }

    public String getId()    // gets the id
    {
        return _id;
    }

    public Date getDateOfBirth()    // gets the date of birth
    {
        return _dateOfBirth;
        //return new Date(_dateOfBirth);
    }

    public Weight getBirthWeight()    // gets the weight at birth
    {
        return _birthWeight;
        //return new Weight(_birthWeight);
    }    

    public Weight getCurrentWeight()    // gets the current weight of the baby
    {
        return _currentWeight;
        //return new Weight(_currentWeight);
    }    

    /**
     * 1 setting method to set the current weight of the baby, only if the weight to set is valid
     */
    public void setCurrentWeight(Weight weightToSet)
    {
        Weight testWeight = new Weight(weightToSet.getKilos(), weightToSet.getGrams());
        if (testWeight.equals(weightToSet)) // if the 2 objects are equal then the weight is valid
            _currentWeight = weightToSet;
    }

    /**
     *  A method to set the current weight of the baby, only if the grams to add are valid
     */
    public void updateCurrentWeight(int gramsToUpdate)
    {
        if (gramsToUpdate == 0) return;     // nothing to do
        Weight newWeight = new Weight(_currentWeight);  // copy current weight
        // Now add the new garms, if the grams to add do not reduce the new weight below 1 kilo 
        newWeight = newWeight.add(gramsToUpdate);
        if (!newWeight.equals(_currentWeight)) // if the 2 objects are equal then the new weight is invalid
            _currentWeight = newWeight; // weights are not equal which means new weight is valid
    }
    
    /**
     *  A method to compare other baby to baby of this object looking at 3 properties only:
     *  First and Last names and id
     */
    public boolean equals(Baby other)
    {
        return (_firstName == other.getFirstName() && 
            _lastName == other.getLastName() &&
            _id == other.getId());
    }
    
    /**
     *  A method to check if other baby is a twin baby of this object looking at 3 properties only:
     *  Last names must be equal, First names and id cannot be equal and
     *  Date of birth must be equal or 1 day apart
     */
    public boolean areTwins(Baby other)
    {
        return (_firstName != other.getFirstName() && 
            _lastName == other.getLastName() &&
            _id != other.getId()  &&
            _dateOfBirth.difference(other.getDateOfBirth()) <= 1);
    }
    
    /**
     *  A method to check if other baby is heavier than the baby of this object
     */
    public boolean heavier(Baby other)
    {
        return other.getCurrentWeight().heavier(_currentWeight);
    }
    
    /**
     *  A method to check if the baby of the object is older than the given baby
     */
    public boolean older(Baby other)
    {
        return !other.getDateOfBirth().before(_dateOfBirth);
    }

    /**
     *  A method to checks if the current weight of this baby is within the valid range based on
     *  it's age, given by the parameter numOfDays, and it's current weight, and compared to
     *  standard medical accepted changes in baby weight during it's first year.
     */
    public int isWeightInValidRange(int numOfDays)
    {
        final int MIN_DAYS_IN_MONTH = 1;
        final int DAYS_IN_YEAR = 365;
        final int DAYS_1ST_PERIOD = 7;
        final int DAYS_2ND_PERIOD = 60;
        final int DAYS_3RD_PERIOD = 120;
        final int DAYS_4TH_PERIOD = 240;
        final double PERCENT_FIRST_PERIOD = 10.0;
        final int INCREASE_GRAMS_2ND_PERIOD = 30;
        final int INCREASE_GRAMS_3RD_PERIOD = 25;
        final int INCREASE_GRAMS_4TH_PERIOD = 16;
        final int INCREASE_GRAMS_5TH_PERIOD = 8;
        final int INVALID_INPUT = 1;
        final int VALID_WEIGHT = 2;
        final int INVALID_WEIGHT = 3;
        
        if (numOfDays < MIN_DAYS_IN_MONTH || numOfDays > DAYS_IN_YEAR) return INVALID_INPUT; // check for a baby ages 1 day to 1 year
        // first week the weight should be lower up to 10% of birth weight
        // each day the reduction in weight 10%/7
        double dailyReductionPercent = (PERCENT_FIRST_PERIOD / DAYS_1ST_PERIOD);
        // if the numOfDays is more than 7 days we calculate the full reduction of 10% as the
        // valid weight
        int numOfDaysToReduce = (numOfDays >= DAYS_1ST_PERIOD ? DAYS_1ST_PERIOD : numOfDays);
        double totalReductionPercent = dailyReductionPercent * (double) numOfDaysToReduce;
        double totalReductionFraction = (100.0 - totalReductionPercent) / 100.0;
        double birthWeightInGrams = _birthWeight.getKilos() * 1000.0 + _birthWeight.getGrams(); 
        int validWeightInGrams = (int)(birthWeightInGrams * totalReductionFraction);
        if (numOfDays > DAYS_1ST_PERIOD)
        {
            // each day between 8 to 60 there should be 30 grams increase of the weight
            int numOfDaysToIncrease = (numOfDays <= DAYS_2ND_PERIOD ? numOfDays - DAYS_1ST_PERIOD: DAYS_2ND_PERIOD - DAYS_1ST_PERIOD);
            validWeightInGrams += numOfDaysToIncrease * INCREASE_GRAMS_2ND_PERIOD;
            if (numOfDays > DAYS_2ND_PERIOD)
            {
                // each day between 61 to 120 there should be 25 grams increase of the weight
                numOfDaysToIncrease = (numOfDays <= DAYS_3RD_PERIOD ? numOfDays - DAYS_2ND_PERIOD: DAYS_2ND_PERIOD);
                validWeightInGrams += numOfDaysToIncrease * INCREASE_GRAMS_3RD_PERIOD;
                if (numOfDays > DAYS_3RD_PERIOD)
                {
                    // each day between 61 to 120 there should be 25 grams increase of the weight
                    numOfDaysToIncrease = (numOfDays <= DAYS_4TH_PERIOD ? numOfDays - DAYS_3RD_PERIOD: DAYS_3RD_PERIOD);
                    validWeightInGrams += numOfDaysToIncrease * INCREASE_GRAMS_4TH_PERIOD;
                    if (numOfDays > DAYS_4TH_PERIOD)
                    {
                        // each day between 61 to 120 there should be 25 grams increase of the weight
                        numOfDaysToIncrease = numOfDays - DAYS_4TH_PERIOD;
                        validWeightInGrams += numOfDaysToIncrease * INCREASE_GRAMS_5TH_PERIOD;
                    }
                }
            }
        }
        Weight validWeight = new Weight(validWeightInGrams); // convert to a Weight object
        return (validWeight.lighter(_currentWeight) ? INVALID_WEIGHT : VALID_WEIGHT);
    }// end of method isWeightInValidRange()

    /**
     *  A method to prepare Baby for printing it's data in a formatted form
     */
    public String toString()
    {
        return "Name: " + _firstName + " " + _lastName +
        "\nId: " + _id +
        "\nDate of Birth: " + _dateOfBirth +
        "\nBirth Weight: " + _birthWeight +
        "\nCurrent Weight: " + _currentWeight +
        "\n";
    }
}// end of class Baby

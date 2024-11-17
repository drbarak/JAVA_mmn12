/**
 * Class Weight:
 *  The Weight class represents the a Weight object that keeps weight of a baby
 *  in kilos and grams parameters in protected internal variables named:
 *      int _kilos,
 *      int _grams.
 *  
 *  The class has 3 constructors:
 *  - Weight(int kilos, int grams)
 *  A constructor that allows to set the value of the object by providing
 *  valid kilos (greater than 0) and grams (between 0 and 999). 
 *  If the weight provided is invalid, in any of the 2 parameters, the weight
 *  created is the default weight of 1 kilo.
 *  - Weight(int totalGrams)
 *  A constructor that gets number of grams and convert to kilos and grams.
 *  - Weight(Weight other)
 *  A constructor that copies a valid weight object.
 *  
 *  The class has 2 retrieving methods to get the internal values of the weight
 *  of the object:
 *      int getKilos()  - Gets the kilos of this object
 *      int getGrams()  - Gets the grams of this object
 *
 *  The class has no setting methods.
 *
 *  The class utilities methods:
 *  - A method to check if this weight is the same as another weight
 *      boolean equals(Weight other)
 *  - A method to check if this weight is lighter than another weight
 *      boolean lighter(Weight other)
 *  - A method to check if this weight is heavier than another weight
 *      boolean heavier(Weight other)
 *  - A method to recieve a new weight object whose weight is this weight plus the provided grams
 *      Weight add(int grams)
 *  - A method to get this weight as a string in the format k.ggg
 *      Examples: 4.07, 3.055, 4.005, 4.0, 4.1
 *      String toString()
 *      
 *  The class has 3 helper internal (private) methods:
 *  - A method to pad a digit with a leading 0
 *      String pad(int num)
 *  - A method to check validity of a weight
 *      boolean checkWeight(int kilos, int grams)
 *
 * @author (Zvika Barak)
 * @ID (050982479)
 * @version (12.11.2024)
 */

import java.util.Scanner;

public class Weight
{
    // instance variables - replace the example below with your own
    private int _kilos;     // values greater than 1
    private int _grams;     // values between 0 and 999

    final int MIN_KILOS = 1;
    final int GRAMS_IN_KILO = 1000;
    final int DEFAULT_GRAMS = 0;
    /**
     * Constructors for objects of class Weight
     */
    public Weight(int kilos, int grams)
    {
        /**
         *  @param  kilos  number of kilos of the weight
         *  @param  grams  number of grams, the fraction of the weight
         */
        // set the instance variables validating it is a valid weight
        // otherwise it set the weight to 1 kilo
        if (checkWeight(kilos, grams))
        {
            _kilos = kilos;
            _grams = grams;
        }    
        else
        {
            _kilos = MIN_KILOS;
            _grams = DEFAULT_GRAMS;
        }
    } // end of constructor Weight(int kilos, int grams)

    public Weight(int grams)
    {
        /**
         *  @param  grams  total weight in grams
         */
        // set the instance variables validating it is a valid weight
        // otherwise it set the weight to 1 kilo
        if (grams > GRAMS_IN_KILO)
        {
            _kilos = grams / 1000;
            _grams = grams % 1000;
        }
        else
        {
            _kilos = MIN_KILOS;
            _grams = DEFAULT_GRAMS;
        }
    }   // end of constructor Weight(int grams)

    public Weight(Weight other)
    {
        /**
         *  @param  other  anothe weight object top copy
         */
        // initialise instance variables for the weight in the object 'other'
        // we assume the weight is valid in the 'other' object
        _kilos = other._kilos;
        _grams = other._grams;
    }   // end of constructor Weight(Weight other)
    /**
     * 2 retrieving methods
     */
    // gets the grams 
    public int getGrams()
    {
        /**
         *  @return    the grams field of the object
         */
        return _grams;
    }
    // gets the kilos
    public int getKilos()
    {
        /**
         *  @return    the kilos field of the object
         */
        return _kilos;
    } 

    /**
     *  method to compare other weight to weight of this object
     */
    public boolean equals(Weight other)
    {
        /**
         *  @param  other  the other weight object to compare to
         *  @return    if the weight of the other object and this object are equal
         */
        return (_kilos == other.getKilos()) && (_grams == other.getGrams());
    }

    /**
     *  Method to check if the weight of the object is less than the given Weight
     */
    public boolean lighter(Weight other)
    {
        /**
         *  @param  other  the other weight object to compare to
         *  @return    if the weight of this object is less than of the other object
         */
        int otherWeight = other.getKilos() * GRAMS_IN_KILO + other.getGrams();
        int thisWeight = _kilos * GRAMS_IN_KILO + _grams;
        return thisWeight < otherWeight;
    }

    /**
     *  Method to check if the weight of the object greater than the given Weight
     */
    public boolean heavier(Weight other)
    {
        /**
         *  @param  other  the other weight object to compare to
         *  @return    if the weight of this object is more than of the other object
         */
        return other.lighter(this);
    }

    /**
     *  method to add grams (can be -ve to reduce weight) to the object's weight
     *  and returns the new weight in a Weight object
     */
    public Weight add(int gramsToAdd)
    {
        /**
         *  @param  gramsToAdd  number of grams to add to this object's weight
         *  @return    if the new weight is valid new object with the new weight
         *              otherwise new object with weight of this object
         */
        // get current weight in grams
        int thisGrams = _kilos * GRAMS_IN_KILO + _grams;
        int newGrams = thisGrams + gramsToAdd;

        if (newGrams < GRAMS_IN_KILO)    // if less than 1 kilo
            return new Weight(_kilos, _grams);    // returns current weight

        return new Weight(newGrams);   // returns new weight
    }

    /**
     *  method to prepare weight for printing in the format k.ggg
     */
    public String toString()
    {
        return _kilos +  "." + pad(_grams);
    }

    // helper method to check validity of weight
    private boolean checkWeight(int kilos, int grams)
    {
        if (grams < 0 || grams >= GRAMS_IN_KILO)    // validate the grams            
            return false;
        if (kilos < MIN_KILOS)        // validate the kilos
            return false;
        return true;
    }   // end of private method checkWeight()
    // helper method to pad grams with a leading zeros and remove trailing zeros
    private String pad(int num)
    {
        if (num == 0)      // 0 grams with no more zeros
            return "0";
        if (num < 10)
            return "00" + num;   // returns 00n - single digit of grams
        if (num < 100)
        {
            if (num % 10 != 0)   // remove trailing '0'
                return "0" + num;   // returns 0nn
            return "0" + num / 10;  // returns 0n - single digit of 10 garms
        }
        if (num % 100 != 0)
        {
            if (num % 10 == 0)
                return "" + num / 10;   // returns nn of 10 grams
            return "" + num;    // returns nnn
        }
        return "" + num / 100;  // returns n (single digit of hunderd grams)
    }
}// end of class Weight

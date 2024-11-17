/**
 * Class Date:
 *  The Date class represents a date and keeps its day, month, year parameters
 *  in protected internal variables, named:
 *      int_day,
 *      int _month,
 *      int _year.
 *  
 *  The class has 3 constructors:
 *  - An empty one that creates a Date object with a default date of 01.01.2024.
 *  - A constructor that allows to set the value of the date by providing
 *  valid day (between 1 and 31), month (between 1 and 12) and year (between
 *  1000 and 9999). The constructor also checks for leap year. If the date
 *  provided is invalid, in any of the 3 parameters, the date created is the
 *  default date.
 *  - A constructor that copies a valid Date object.
 *  
 *  The class has 3 retrieving methods to get the internal values of the Date:
 *  int getDay(), int getMonth(), int getYear()
 *
 *  The class has 3 setting methods to set the internal values of the Date:
 *  void setDay(int dayToSet), void setMonth(int monthToSet), void setYear(int yearToSet)
 *
 *  The class utilities methods:
 *  - A method to compare given date to date of the object
 *      boolean equals(Date other)
 *  - A method to check if the date of the object is earlier than the object
 *      boolean before(Date other)
 *  - A method to check if the date of the object is later than the object
 *      boolean after(Date other)
 *  - A method to calculate the days between a given date and the object
 *      int difference(Date other)
 *  - A method to get the date a day after the object
 *      Date tomorrow()
 *  - A method to get the object as a string in the format dd/mm/yyyy
 *      String toString()
 *      
 *  The class has 3 helper internal (private) methods:
 *  - A method to pad a digit with a leading 0
 *      String pad(int num)
 *  - A method to check validity of a date
 *      boolean checkDate(int day, int month, int year)
 *  - A method to calculate the number of days since 01.01.0000     
 *      int calculateDate(int day, int month, int year)
 *
 * @author (Zvika Barak)
 * @ID (050982479)
 * @version (12.11.2024)
 */

import java.util.Scanner;

public class Date
{
    // instance variables
    private int _day;       // values between 1 and 31
    private int _month;     // values between 1 and 12
    private int _year;      // values between 1000 and 9999

    final int DEFAULT_DAY = 1;
    final int DEFAULT_MONTH = 1;
    final int DEFAULT_YEAR = 2024;

    final int FEBRUARY = 2;
    final int APRIL = 4;
    final int JUNE = 6;
    final int SEPTEMBER = 9;
    final int NOVEMBER = 11;
    
    final int DAYS_IN_YEAR = 365;
    final int MIN_DAYS_IN_MONTH = 1;
    final int MAX_DAYS_IN_MONTH = 31;
    final int MIN_DAYS_IN_FULL_MONTH = 28;
    final int NUM_DAYS_IN_FEBRUARY_LEAP_YEAR = 29;
    final int MIN_YEARS = 1000;
    final int MAX_YEARS = 9999;
    final int FIRST_MONTH = 1;
    final int NUM_OF_MONTHS_IN_YEAR = 12;
    final int ONE_DAY = 1;
    final int ONE_MONTH = 1;

    final int LEAP_YEARS = 4;
    final int HUNDRED_YEARS = 100;
    final int FOUR_HUNDRED_YEARS = 400;

    /**
     * Constructors for objects of class Date
     */
    public Date()
    {
        // initialise instance variables for the date 01.01.2024
        _day = DEFAULT_DAY;
        _month = DEFAULT_MONTH;
        _year = DEFAULT_YEAR;
    }   // end of constructor Date()

    public Date(int day, int month, int year)
    {
        // set the instance variables validating it is a valid date
        // otherwise it set the date to 01.01.2024
        if (checkDate(day, month, year))
        {
            _day = day;
            _month = month;
            _year = year;
        }    
        else
        {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    } // end of constructor Date(int day, int month, int year)

    public Date(Date other)
    {
        // initialise instance variables for the date in the object 'other'
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }   // end of constructor Date(Date other)
    /**
     * 3 retrieving methods
     */
    // gets the year
    public int getYear()
    {
        return _year;
    }
    // gets the month 
    public int getMonth()
    {
        return _month;
    }
    // gets the Day
    public int getDay()
    {
        return _day;
    } 

    /**
     * 3 setting methods
     */
    public void setDay(int dayToSet)
    {
        if (checkDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    public void setMonth(int monthToSet)
    {
        if (checkDate(_day, monthToSet, _year))
            _month = monthToSet;
    }

    public void setYear(int yearToSet)
    {
        if (checkDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    /**
     *  A method to compare other date to date of this object
     */
    public boolean equals(Date other)
    {
        return (_day == other.getDay() && _month == other.getMonth() &&
            _year == other.getYear());
    }

    /**
     *  A method to check if the date of the object earlier than the given date
     */
    public boolean before(Date other)
    {
        int otherDays = calculateDate(other.getDay(), other.getMonth(), other.getYear());
        int thisDays = calculateDate(_day, _month, _year);
        return thisDays < otherDays;
    }

    /**
     *  A method to check if the date of the object later than the given date
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }

    /**
     *  A method to calculate the days between a given date and the object
     */
    public int difference(Date other)
    {
        int otherDays = calculateDate(other.getDay(), other.getMonth(), other.getYear());
        int days = calculateDate(_day, _month, _year);
        return Math.abs(days - otherDays);
    }
    /**
     *  A method to get the date one day after the date of this object
     */
    public Date tomorrow()
    {
        // add one day if it is a valid date exit
        int day = _day;
        int month = _month;
        int year = _year;
        if (checkDate(day + ONE_DAY, month, year))
            day++;
        else
        {
            day = ONE_DAY;
            if (checkDate(day, month + ONE_MONTH, year))
                month++;
            else
            {
                month = FIRST_MONTH;
                year++;
            }
        }
        return new Date(day, month, year);
    }

    /**
     *  A method to prepare date for printing in the format dd/mm/yyyy
     */
    public String toString()
    {
        return pad(_day) +  "/" + pad(_month) + "/" + _year;
    }
    // helper method to check validity of date
    private boolean checkDate(int day, int month, int year)
    {
        if (year < MIN_YEARS || year > MAX_YEARS) // validate the year
            return false;
        if (month < FIRST_MONTH || month > NUM_OF_MONTHS_IN_YEAR)    // validate the month            
        {
            return false;
        }
        if (day < MIN_DAYS_IN_MONTH || day > MAX_DAYS_IN_MONTH)        // validate the day
            return false;
        if (month == FEBRUARY)                 // validate leap year
        {
            if (day > NUM_DAYS_IN_FEBRUARY_LEAP_YEAR)
                return false;
            else if (day == NUM_DAYS_IN_FEBRUARY_LEAP_YEAR)
            {
                // not a leap year if does not divides by 400
                if (year % FOUR_HUNDRED_YEARS != 0)
                {
                    // not a leap year if does not divides by 4 or not by 100
                    if (year % LEAP_YEARS != 0 || year % HUNDRED_YEARS == 0)
                        return false;
                }
            }
        } 
        else if (day > MIN_DAYS_IN_FULL_MONTH)
        {
            // only months 1,3,5,7,8,10,12 can have 31 days
            if (day == MAX_DAYS_IN_MONTH && 
                    (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER))
                return false;
        }
        return true;
    }   // end of private method checkDate()
    // helper method to pad a digit with a leading 0
    private String pad(int num)
    {
        return (num < 10 ? "0" + num : "" + num);
    }
    // helper method to calculate the numbers of days since 01.01.0000 + 1
    private int calculateDate(int day, int month, int year)
    {
        if (month <= FEBRUARY)
        {
            year--;
            month += NUM_OF_MONTHS_IN_YEAR;
        }
        return DAYS_IN_YEAR*year + year/LEAP_YEARS - year/HUNDRED_YEARS + 
            year/FOUR_HUNDRED_YEARS + ((month+1)*306)/10 + (day-2*MAX_DAYS_IN_MONTH);
    }
}// end of class Date

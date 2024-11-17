
/**
 * Write a description of class DateTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class DateTest
{

    // method to test the class
    public static void main(String[] args)
    {
        System.out.println("Enter 3 numbers, seperated by space," +  
                    "for day, month, year: ");
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        
        Date testDate = new Date(day, month, year);
        System.out.println("Date saved: " + testDate);
        /*
        Date testDate2 = new Date(testDate);
        System.out.println("date equals? " + testDate.equals(testDate2));
        System.out.println("date equals2? " + testDate2.equals(testDate));
        
        // test setting method
        testDate.setDay(testDate.getDay() + 1);
        testDate.setMonth(testDate.getMonth() + 1);
        testDate.setYear(testDate.getYear() + 1);
        System.out.println("Date modified: " + 
            testDate.toString(testDate.getDay(), testDate.getMonth(), 
            testDate.getYear()));
        //System.out.println("date equals3? " + testDate2.equals(testDate));
        //System.out.println("num of days = " + _calculateDate(day, month, year));
        //System.out.println("before " + testDate2.before(testDate));
        //System.out.println("after " + testDate2.after(testDate));
        //System.out.println("difference " + testDate2.difference(testDate));
        */
       Date tomorrow = testDate.tomorrow(); 
        System.out.println("Tomorrow: " + tomorrow);
    }
}

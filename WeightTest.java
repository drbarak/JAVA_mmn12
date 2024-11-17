
/**
 * Write a description of class WeightTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class WeightTest
{
    // method to test the class
    public static void main(String[] args)
    {
        System.out.println("Enter 4 numbers, seperated by space," +  
                    "for kilos, grams, addGrams, totalGrams: ");
        Scanner scan = new Scanner(System.in);
        int kilos = scan.nextInt();
        int grams = scan.nextInt();
        int addGrams = scan.nextInt();
        int totalGrams = scan.nextInt();
        
        Weight testWeight = new Weight(kilos, grams);
        System.out.println("Weight saved: " + testWeight);
        
        Weight testWeight2 = new Weight(testWeight);
        System.out.println("weight equals? " + testWeight.equals(testWeight2));
        Weight testWeight3 = new Weight(totalGrams);
        System.out.println("weight equals2? " + testWeight3.equals(testWeight));
        // test setting method
        testWeight = testWeight.add(addGrams); // add/subtract few grams
        System.out.println("Weight modified: " + testWeight);
        System.out.println("weight equals3? " + testWeight2.equals(testWeight));
        //System.out.println("num of kiloss = " + _calculateWeight(kilos, grams, year));
        System.out.println("before " + testWeight2.lighter(testWeight));
        System.out.println("after " + testWeight2.heavier(testWeight));
        //System.out.println("difference " + testWeight2.difference(testWeight));
        /*
       Weight tomorrow = testWeight.tomorrow(); 
        System.out.println("Tomorrow: " + 
            tomorrow.toString(tomorrow.getKilos(), tomorrow.getGrams(), 
            tomorrow.getYear()));
        */
    }
}

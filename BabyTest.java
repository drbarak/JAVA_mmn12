
/**
 * Write a description of class BabyTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class BabyTest
{

    // method to test the class
    public static void main(String[] args)
    {
        System.out.println("Enter first name, last name, id, " +  
            "day, month, year, weight in grams: ");
        Scanner scan = new Scanner(System.in);

        //Baby testBaby1 = new Baby(scan.nextLine(), scan.nextLine(), scan.nextLine(),
        //  scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.println("WARNING: NEED TO KNOW WHAT TO DO IF GIVEN WEIGHT TO CONSTRUCTOR IS INVALID\n - DO WE LET THE WEIGHT CONSTRUCOTR TO SET IT TO DEFAULT DATE");
        Baby testBaby = new Baby("Uriel", "Barak", "050982479", 25, 10, 2024, 2740);
        System.out.println("\nBaby getter:\n" + testBaby);
        Baby testBaby2 = new Baby(testBaby);
        System.out.println("Baby names & id equals? " + testBaby.equals(testBaby2));
        
        System.out.println("WARNING2: NEED TO KNOW IF IN GET_DATE NEEDS NEW() OR NO");
        testBaby2.getDateOfBirth().setDay(3);
        System.out.println("Baby2 date of birth " + testBaby2.getDateOfBirth()); 
        System.out.println("Baby date of birth " + testBaby.getDateOfBirth()); 
        
        System.out.println("Baby2: " + testBaby2);
        System.out.println("Baby names & id equals2? " + testBaby2.equals(testBaby));

        System.out.println("Baby twins2? " + testBaby2.areTwins(testBaby));
        testBaby = new Baby(testBaby.getFirstName() + "_2", testBaby.getLastName(),
            testBaby.getId() + "_2", testBaby.getDateOfBirth().getDay(), 
            testBaby.getDateOfBirth().getMonth(), 
            testBaby.getDateOfBirth().getYear(), 
            testBaby.getBirthWeight().getKilos() * 1000 + 
            testBaby.getBirthWeight().getGrams());
        System.out.println("Baby modified:\n" + testBaby);
        System.out.println("Baby twins3? " + testBaby2.areTwins(testBaby));
        testBaby.getDateOfBirth().setYear(2022);
        System.out.println("Baby modified date of birth:\n" + testBaby);
        System.out.println("Baby twins4? " + testBaby2.areTwins(testBaby));

        Date tomorrow = testBaby2.getDateOfBirth().tomorrow();
        testBaby.getDateOfBirth().setDay(tomorrow.getDay());
        testBaby.getDateOfBirth().setMonth(tomorrow.getMonth());
        testBaby.getDateOfBirth().setYear(tomorrow.getYear());
        System.out.println("Baby tomorrow date of birth:\n" + testBaby);
        System.out.println("Baby twins5? " + testBaby2.areTwins(testBaby));
        System.out.println("Baby heavier? " + testBaby2.heavier(testBaby));
        System.out.println("Baby weight equal? " + testBaby2.getCurrentWeight().equals(testBaby.getCurrentWeight()));
        Weight newWeight = new Weight(testBaby.getCurrentWeight().getKilos(), 
                testBaby.getCurrentWeight().getGrams() + 1);
        testBaby.setCurrentWeight(newWeight);
        System.out.println("Baby new weight:\n" + testBaby);
        System.out.println("Baby heavier? " + testBaby2.heavier(testBaby));

        testBaby.updateCurrentWeight(0);
        System.out.println("Baby updated weight 0:\n" + testBaby);
        testBaby.updateCurrentWeight(-100);
        System.out.println("Baby updated weight -100:\n" + testBaby);
        testBaby.updateCurrentWeight(-10000);
        System.out.println("Baby updated weight -10000:\n" + testBaby);
        testBaby.updateCurrentWeight(2034);
        System.out.println("Baby updated weight 2034:\n" + testBaby);

        System.out.println("Baby older? " + testBaby.older(testBaby2));
        System.out.println("Baby2 older? " + testBaby2.older(testBaby));

        testBaby2.updateCurrentWeight(180); // Uriel weight aftre 2 weeks increased by 180 grams
        System.out.println("Uriel updated weight 180:\n" + testBaby2);
        System.out.println("Uriel valid weight 5 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(5));
        System.out.println("Uriel valid weight 14 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(14));
        /*        
        System.out.println("Baby valid weight 59 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(59));
        System.out.println("Baby valid weight 80 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(80));
        System.out.println("Baby valid weight 121 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(121));
        System.out.println("Baby valid weight 250 days (2=less 3=valid): " + testBaby2.isWeightInValidRange(250));
         */ 
        Baby miaBaby = new Baby("Mia", "Ben Shimol", "00000000", 11, 05, 2024, 3615);
        System.out.println("Mia data:\n" + miaBaby);
        checkWeight(miaBaby, 3414, 2);
        checkWeight(miaBaby, 3510, 9);
        checkWeight(miaBaby, 3940, 14);
        checkWeight(miaBaby, 4720, 43);
        checkWeight(miaBaby, 4810, 47);
        checkWeight(miaBaby, 5770, 78);
        checkWeight(miaBaby, 7020, 127);       
        checkWeight(miaBaby, 8100, 175);       
    }

    private static void checkWeight(Baby baby, int updatedWeight, int numDays)
    {
        int birthWeight = baby.getCurrentWeight().getKilos() * 1000 + baby.getCurrentWeight().getGrams();
        baby.updateCurrentWeight(updatedWeight - birthWeight);
        //System.out.println("ValidWeight is: " + validWeightInGrams);
        System.out.println("Mia weight score after " +  numDays + " days: " + 
            baby.isWeightInValidRange(numDays) + ", "  + baby.getCurrentWeight());
    }

    private static void p(String s)
    {
        System.out.println(s);
    }

    private static void p(int s)
    {
        p(" " + s);
    }
    private static void p(int n1, int n2)
    {
        p("" + n1 + ", " + n2);
    }
    private static void p(int n1, int n2, int n3)
    {
        p("" + n1 + ", " + n2 + ", " + n3);
    }
}

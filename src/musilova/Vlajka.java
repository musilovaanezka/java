package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Vlajka {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Vyska vlajky");
        int vyska = sc.nextInt();
        System.out.println("Sirka vlajky");
        int sirka = sc.nextInt();
        
        for (int i = 1; i <= vyska / 2; i++) {
            for (int hvezdicka = 1; hvezdicka <= i; hvezdicka++) {
                System.out.print("* ");
                
            } for (int minus = 1; minus <= sirka - i; minus++) {
                System.out.print("- ");
                
            } 
            System.out.println("");
            
        } for (int i = vyska / 2; i > 0; i--) {
            for (int hvzd = 1;hvzd <= i;hvzd++) {
                System.out.print("* ");
                
            } for (int krouzek = 1;krouzek <= sirka - i; krouzek++) {
                System.out.print("o ");
                
            } 
            System.out.println("");
        }
    }

}

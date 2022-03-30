package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class DelitelnostCelehoCisla {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean opakovat = true;
        
        do {
            System.out.println("Dve cela cisla:");
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a % b == 0) {
                System.out.println("Prvni cislo je delitelne druhym");
            } else if (b % a == 0) {
                System.out.println("Druhe cislo je delitelne prvnim");
            } else {
                System.out.println("Cisla nejsou vzejemne delitelna");
            }
            System.out.println("Opakovat? a/n");
            if () {
                opakovat = false;
                System.out.println("Uloha ukoncena");
            }
            
        } while (opakovat == true);
    }

}

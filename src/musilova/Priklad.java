package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Priklad {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cteni posloupnosti + cisel
        // posloupnost cisel ukoncena terminatorem 
        // terminator = 0 / zaporne cislo 
        
        //cteni posloupnosti cisel 
        System.out.println("Pocet");
        int n = sc.nextInt(); 
        System.out.println("Cislo");
        
        
        for(int i = 0; i < n; i++) {
            float x = sc.nextFloat();
            // zpracování čísla x 
        }
        // výsledek zpracování celé posloupnosti 
        
        // pouze pro + cisla ukoncena terminatorem - s do-while
        System.out.println("cisla, ukonceno 0 / zapornym cislem");
        float x;
        do {
            x = sc.nextFloat();
            if (x > 0) {
                // zpracovani cisla
            }
        } while (x > 0);
        
        // pouze pro + cisla ukoncena terminatorem - s while
        while (x > 0) {
            while ((x = sc.nextFloat()) > 0) {
                // zpracovani cisla 
            }
        }
        // vysledek zpracovani sekvence 
    }

}

package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PocetVyskytuMaxima {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Svekcence celych cisel ukoncena 0 / zapornym cislem");
        
        int max = 0;
        int cislo;
        int pocetMax = 0;
        
        while ((cislo = sc.nextInt()) > 0){
            if (cislo > max) {
                max = cislo;
                pocetMax = 0;
            }
            if (cislo == max) {
                pocetMax++;
            }
        }
        System.out.println(pocetMax);
    }

}

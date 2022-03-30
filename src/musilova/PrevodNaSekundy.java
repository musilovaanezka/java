package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PrevodNaSekundy {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Počet hodin, minut, sekund");
        int hodiny = sc.nextInt();
        int minuty = sc.nextInt();
        int sekundy = sc.nextInt();
        
        int pocet_sekund = hodiny * 3600 + minuty * 60 + sekundy;
        System.out.format("Počet sekund je: %d s %n" ,pocet_sekund);
    }

}

package morePractice;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Prumer {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Počet hodnot:");
        int n = sc.nextInt();
        System.out.println("Hodnoty:");
        double hodnota;
        double v = 0;
        
        for (int i = 0; i < n; i++){
            hodnota = sc.nextDouble();
            v += hodnota;
        }
        System.out.println("Průměr = " + (v / n));
    }

}

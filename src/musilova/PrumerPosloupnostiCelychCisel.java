package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PrumerPosloupnostiCelychCisel {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Pocet");
        int n = sc.nextInt();
        System.out.println("Sekvence");
        
        float prumer = 0;
        
        for(int i = 0; i < n; i++) {
            float x = sc.nextInt();
            prumer = x + prumer; 
        }
        System.out.println(prumer / n);
    }

}

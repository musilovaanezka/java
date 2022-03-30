package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Hvezdicky {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("n:");
        int n = sc.nextInt();
        
        //radek hvezdicek
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
            
        }
        System.out.println();
        
        //pravouhly trojuhelnik
        for (int i = 0; i < n + 1; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}

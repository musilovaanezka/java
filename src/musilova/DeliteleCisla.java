package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class DeliteleCisla {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Cele cislo");
        int a = sc.nextInt();
        int delitel = 2;
        
        while (delitel < (a - 1)) {
            if (a % delitel == 0){
                System.out.println(delitel);
            }
            delitel++;
        }
    }

}

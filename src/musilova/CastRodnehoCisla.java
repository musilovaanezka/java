package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class CastRodnehoCisla {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Rok narozeni:");
        int rok = sc.nextInt();
        
        System.out.println("Mesic narozeni:");
        int mesic = sc.nextInt();
        
        System.out.println("Den narozeni:");
        int den = sc.nextInt();
        
        System.out.println("Pohlavi: z/m");
        String pohl = sc.next();
        (pohl.equals("zena")) ? 
    }

}

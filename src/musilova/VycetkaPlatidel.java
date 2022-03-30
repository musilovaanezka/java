package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class VycetkaPlatidel {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Částka v Kč:");
        int c = sc.nextInt();
        
        int s = c % 100; 
        int pd = (c - (s * 100)) % 50;
        int dc = (c - (50 * pd) - (s * 100)) % 20;
        int ds = (c - (dc * 20) - (50 * pd) - (s * 100)) % 10;
        int k = c % 2;
        int d = 
        
    }

}

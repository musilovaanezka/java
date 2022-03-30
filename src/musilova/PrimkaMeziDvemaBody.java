package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PrimkaMeziDvemaBody {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Dva body v rovine");
        System.out.println("Bod a:");
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        
        System.out.println("Bod b:");
        int bx = sc.nextInt();
        int by = sc.nextInt();
        
        //smernovy vektor 
        int u1 = bx - ax;
        int u2 = by - ay;
        
        //parametricky
        System.out.format("x = %d + %d*t %n y = %d + %d*t %n", ax, u1, ay, u2);
        
        //obecně
        int c = (u2*ax) - (u1*ay);
        System.out.format("%dx + %dy + %d = 0", ((-1)*u2), u1, c);
        
    }

}

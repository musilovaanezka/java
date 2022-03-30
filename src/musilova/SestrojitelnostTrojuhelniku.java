package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class SestrojitelnostTrojuhelniku {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("3 delky stran trojuhelniku:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        //serazeni tri hodnot
        double s = a + b + c;
        a = Math.max(a, Math.max(b, c));
        c = Math.min(a, Math.min(b, c));
        b = s - a - c;
        
        //overeni sestrojitelnosti trojuhelniku
        if (((a + b) > c) && ((c + a) > b)) {
            System.out.println("Trojuhelnik lze sestrojit");
            
            //jaky typ ma trojuhelnik 
            //rovnoramenny 
            if (c == b || c == a || b == a) {
                if (a != b || b != c) {
                    System.out.println("Trojuhelnik je rovnoramenny");
                } else {
                    System.out.println("Trojuhelnik je rovnostranny");
                }
            //pravouhly 
            } else if ((a*a) == (b*b + c*c)) {
                if (c == b) {
                    System.out.println("Trojuhelnik je rovnoramenny pravouhly");
                } else {
                    System.out.println("Trojuhelnik je obecne pravouhly");
                }
            } else {
                System.out.println("Trojuhelnik je obecny");
            }
            
        } else {
            System.out.println("Trojuhelnik nelze sestrojit");
        }
        
    }

}

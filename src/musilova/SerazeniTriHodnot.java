package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class SerazeniTriHodnot {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tri ciselne hednoty:");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        
        float prvni = 0;
        float druhe = 0;
        float treti = 0;
        
        if (a > b && a > c) {
            prvni = a;
            if (b > c) {
                druhe = b;
                treti = c;
            } else {
                druhe = c;
                treti = b;
            }
        } else if (a < b && b > c) {
            prvni = b;
            if (a > c) {
                druhe = a;
                treti = c;
            } else {
                druhe = c;
                treti = a;
            }
        } else if (a < b && b < c) {
            prvni = c;
            druhe = b; 
            treti = a;
        } else {
            if (a == b && b == c) {
                prvni = druhe = treti = a;
            }
            else if (a == b && a < c) {
                prvni = c; 
                druhe = a;
                treti = b;
            } else {
                prvni = b;
                druhe = a;
                treti = c;
            }
        }
        System.out.println("V sestupnem poradi?: a/n");
        String odpoved = sc.next();
        if (odpoved.equals("a")) {
            System.out.format("%f %n %f %n %f %n" ,prvni, druhe, treti);
        } else if (odpoved.equals("n")) {
            System.out.format("%f %n %f %n %f %n" ,treti, druhe, prvni);
        } else {
            System.out.println("To nebude platna odpoved");
        }
            
    }

}

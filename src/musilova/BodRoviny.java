package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class BodRoviny {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Souradnice bodu: (x y)");
        float x = sc.nextFloat();
        float y = sc.nextFloat();
        
        if (x > 0 && y > 0) {
            System.out.println("Bod lezi v kvadrantu No. 1");
        } else if (x < 0 && y > 0) {
            System.out.println("Bod lezi v kvadrantu No. 2");
        } else if (x < 0 && y < 0) {
            System.out.println("Bod lezi v kvadrantu No. 3");
        } else if (x > 0 && y < 0) {
            System.out.println("Bod lezi v kvadrantu No. 4");
        } else if (x == 0 && y == 0) {
            System.out.println("Bod lezi v pocatku souradnic");
        } else if (x == 0 && y > 0) {
            System.out.println("Bod lezi na ose Y");
        } else {
            System.out.println("Bod lezi na ose X");
        }
        
    }

}

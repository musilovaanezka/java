package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class MinAMaxRealnychKladnychCisel {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("cisla, ukonceno 0 / zapornym cislem");
        float x;
        float min = Float.MAX_VALUE;
        float max = 0;
        
        while ((x = sc.nextFloat()) > 0) {
            if (x > max) {
                max = x;
            } 
            if (x < min) {
                min = x;
            }
        }
        System.out.format("min = %f %nmax = %f %n" , min, max);
    }

}

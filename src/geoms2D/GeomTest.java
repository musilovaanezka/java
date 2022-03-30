package geoms2D;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class GeomTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Geom2D[] g = new Geom2D[3];
        g[0] = new Trojuhelnik(10, 3, 5);
        g[1] = new Obdelnik(5, 2);
        g[2] = new Ctverec(3);
        
        for (Geom2D geom : g) {
            System.out.println(geom.toString());
        }
        
        
    }

}

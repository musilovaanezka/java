package geoms3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class TestGeom3D {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Geom3D> g = new ArrayList<>();
        g.add(Geom3D.getInstance(5));
        g.add(Geom3D.getInstance(3, 5, 2));
        g.add(Geom3D.getInstance(8));
        g.add(Geom3D.getInstance(9, 10, 11));
                
        System.out.println("");
        
        Collections.sort(g);
        
        for(Geom3D gms : g) {
            System.out.println(gms + " " + gms.getPV());
        }
        
        Collections.sort(g, Geom3D.COMP_P);
    }

}

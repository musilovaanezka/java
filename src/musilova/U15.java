package musilova;

/**
 *
 * @author Musilová
 */

import java.util.Scanner;

public class U15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        
        System.out.println("Délky stran kvádru v cm:");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        
        //objem kvádru
        double kV = a * b * c;
        System.out.println(String.format("Objem kvádru = %.2f. ml", kV));
        
        //strana krychle
        double k = Math.cbrt(kV);
        System.out.println(String.format("Strana krychle = %.2f. cm", k));
        
        //plášť kvádru
        System.out.println(String.format("Plocha pláště kvádru = %.2f. cm^2", 2*((a*b) + (a*c) + (b*c))));
        
        //plášť krchle
        System.out.println(String.format("Plocha pláště krychle = %.2f. cm^2", 6 * (Math.pow(k, 2))));
        
        //poloměr koule
        double r = Math.cbrt((3*kV)/(4*Math.PI));
        System.out.println(String.format("Poloměr koule = %.2f. cm", r));

        //plášť koule
        System.out.println(String.format("Plocha pláště krychle = %.2f. cm^2", 4 * Math.PI * (Math.pow(r, 3))));
        
        //plášť čtyřstěnu
        double l = Math.cbrt((12 * kV) / Math.sqrt(2));
        System.out.println(String.format("Plocha pláště čtyřstěnu = %.2f. cm^2", (Math.sqrt(3)) * (Math.pow(l, 2))));
    }

}

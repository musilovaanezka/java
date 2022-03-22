// soucet
// soucin
package musilova.Polynomy;

import java.util.Arrays;

/**
 *
 * @author Musilová
 */
public final class Polynomy {
    private Polynomy() {}
    public static Polynom soucet(Polynom a, Polynom b) {
        int min = Math.min(a.getStupen(), b.getStupen());
        int max = Math.max(a.getStupen(), b.getStupen());
        double[] suma = new double[max + 1]; 
        for (int i = 0; i < min + 1; i++) {
            suma[i] = a.getKoef(i) + b.getKoef(i);
        }
        if (min != max) { 
            for (int j = min + 1; j < max + 1; j++) {
                if (a.getStupen() < max) {
                    suma[j] = b.getKoef(j);
                } else {
                    suma[j] = a.getKoef(j);
                }
            }
        }
        return Polynom.getPolynom(suma);
    }
    public static Polynom soucin(Polynom a, Polynom b) {
        int al = a.getStupen() + 1;
        int bl = b.getStupen() + 1;
        double[] scin = new double[al + bl - 1];
        for (int i = 0; i < al; i++) {
            for (int j = 0; j < bl; j++) {
                scin[i + j] += a.getKoef(i) * b.getKoef(j);
            }
        }
        return Polynom.getPolynom(scin);
    }
    
    public static void main(String[] args) {
        double[] a = {5, 0, 10, 6};
        double[] b = {1, 2, 4};
        Polynom ap = Polynom.getPolynom(a);
        Polynom bp = Polynom.getPolynom(b);
        System.out.println(ap.toFmString());
        System.out.println(bp.toFmString());
        System.out.println(soucet(ap, bp).toFmString());
        System.out.println(soucin(ap, bp).toFmString());
    }
}

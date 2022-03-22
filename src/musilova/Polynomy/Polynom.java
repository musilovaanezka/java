
// finální atributy
// atributy 
//      pole koeficientů - double[]
// metody 
//      konstruktor
//      tovární metoda getInstance(double... a)
//      getStupen
//      getKoef
//      getHodnota -> double
//      getDerivace -> polynom
//      toFmtString
package musilova.Polynomy;

import java.util.Arrays;

/**
 *
 * @author Musilová
 */
public class Polynom {
    private double[] koef;
    
    private Polynom(double[] koef) {
        this.koef = koef;
    }
    public static Polynom getPolynom(double... a) {
        // kontrola parametru a
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("nebyl zadan spravny parametr");
        }
        // zjistejni posledniho nenuloveho prvku
        int i = a.length - 1;
        while(a[i] == 0 && i > 0) {
            i--;
        }
        double[] pole = Arrays.copyOfRange(a, 0, i + 1);
        return new Polynom(pole);
    } 
    public int getStupen() {
        return koef.length - 1;
    }
    
    public double getKoef(int index) {
        if (index < 0 || index >= this.koef.length) return 0.;
        return this.koef[index];
    }
    public double getHodnota(double x) {
        double suma = this.koef[this.koef.length - 1];
        for (int i = this.koef.length - 2; i >= 0; i++) {
            suma = suma * x + koef[i];
        }
        return suma;
    }
    public Polynom getDerivace() {
        double[] d = new double[this.koef.length - 1];
        for (int i = 0; i < d.length; i++) {
            d[i] = this.koef[i + 1] * i+1;
        }
        return new Polynom(d);
    }
    public String toFmString() {
        String p = "";
        for (int i = 0; i < this.koef.length; i++) {
            switch (i) {
                case 0:
                    p = p + this.koef[i];
                    break;
                case 1:
                    p = p + " + " + this.koef[i] + "x";
                    break;
                default:
                    p = p + " + " + this.koef[i] + "x^" + i;
                    break;
            }
        }
        return p;
    }
}

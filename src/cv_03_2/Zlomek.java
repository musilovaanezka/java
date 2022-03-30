// atributy
//      citatel
//      jmenovatel
// metody 
//      konstruktor
//      getCitatel
//      getJmenovatel
//      gePrevraceny
//      getOpacny (s opacnym znamenkem)
//      toDouble
//      toString
//      equals
//      hashcode
//      parseZlomek(String) -> zlomek - static

package cv_03_2;

/**
 *
 * @author Musilová
 */
public class Zlomek {
    
    private final int cit;
    private final int jm;
    
    public Zlomek(int cit, int jm) {
        int d = maxSpolDel(cit, jm);
        if (jm == 0) {
            throw new IllegalArgumentException("jmenovatel roven 0");
        }
        if (jm < 0) {
            cit = -cit;
            jm = Math.abs(jm);
        }
        this.cit = cit / d;
        this.jm = jm / d;
    }
    
    private static int maxSpolDel(int a, int b) {
        int c;
        while (b != 0) {
            c = b; 
            b = a % b;
            a = c;
        }
        return a;
    }
    public int getCitatel() {
        return this.cit;
    }
    public int getJmenovatel() {
        return this.jm;
    }
    public Zlomek getPrevraceny() {
        return new Zlomek(this.jm, this.cit);
    }
    public Zlomek getOpacny() {
        return new Zlomek(-this.cit, this.jm);
    }
    public double toDouble() {
        return ((double) this.cit)/ this.jm;
    }
    @Override
    public String toString() {
        return (this.cit + "/" + this.jm);
    }
    public static Zlomek parseZlomek(String str) {
        String[] pole = str.split("/");        
        return new Zlomek(Integer.parseInt(pole[0]), Integer.parseInt(pole[1]));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zlomek other = (Zlomek) obj;
        if (this.cit != other.cit) {
            return false;
        }
        if (this.jm != other.jm) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.cit;
        hash = 67 * hash + this.jm;
        return hash;
    }
    
    
}

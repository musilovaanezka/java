/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.cisla;

/**
 *
 * @author Musilová
 */
public class KomplexniCislo {
    private final double rC;
    private final double kC;
    private final double absH;
    
    // konstruktor souradnicovy
    public KomplexniCislo(double x, double y) {
        this.rC = x;
        this.kC = y;
        this.absH = Math.sqrt((x * x) + (y * y));
    }
    
    // konstruktor souctovy
    public KomplexniCislo(String soucet) {
        soucet = soucet.replaceAll(" ", "");
        String[] s = soucet.split("\\+");
        this.rC = Double.valueOf(s[0]);
        String[] i = s[1].split("i");
        if (i[0].trim().length() < 1) {
            this.kC = 1;
        } else {
            this.kC = Double.valueOf(i[0]);
        }        
        this.absH = Math.sqrt((rC * rC) + (kC * kC));
    }
    public double getrC() {
        return rC;
    }

    public double getkC() {
        return kC;
    }

    public double getAbsH() {
        return absH;
    }
    
    public double getUhel() {
        return Math.cos(rC / absH);
    }
    
    @Override
    public String toString() {
        return (rC + "+" + kC + "i");
    }
    
    // komplexne struzene cislo
    public KomplexniCislo KomplexneSdruzene() {
        return new KomplexniCislo(rC, kC * -1);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.rC) ^ (Double.doubleToLongBits(this.rC) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.kC) ^ (Double.doubleToLongBits(this.kC) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.absH) ^ (Double.doubleToLongBits(this.absH) >>> 32));
        return hash;
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
        final KomplexniCislo other = (KomplexniCislo) obj;
        if (Double.doubleToLongBits(this.rC) != Double.doubleToLongBits(other.rC)) {
            return false;
        }
        if (Double.doubleToLongBits(this.kC) != Double.doubleToLongBits(other.kC)) {
            return false;
        }
        if (Double.doubleToLongBits(this.absH) != Double.doubleToLongBits(other.absH)) {
            return false;
        }
        return true;
    }

    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoms3D;

import java.util.Comparator;

/**
 *
 * @author Musilová
 */
public interface Geom3D extends Comparable<Geom3D> {
    public double getV(); 
    public double getP();
    
    public static Geom3D getInstance(double... a) {
        if (a == null) return null;
        else if (a.length == 0) return null;
        else if (a.length == 1) return Krychle.getInstance(a[0]);
        else if (a.length == 3) return Kvadr.getInstance(a[0], a[1], a[2]);
        else return null;
    }
    
    public static Geom3D getInstance(Typ3DO typ, double... a) {
        swtich (typ) {
            case KRYCHLE:
                return Krychle.getInstance(a[0]);
            case KVADR:
                return Kvadr.getInstance(a[0], a[1], a[2]);
        }
    }
    
    public static enum Typ3DO {
        KRYCHLE, KVADR
    }
    
    public static final Comparator<Geom3D> COMP_P = new Comparator<>(){
        @Override
        public int compare(Geom3D o1, Geom3D o2) {
            return (int) Math.round(Math.signum((o1.getV() - o2.getV())));
        }
    };
    
    public default String getPV() {
        return "Plocha = " + getP() + " Objem = " + getV();  
    } 

    @Override
    public default int compareTo(Geom3D o) {
        return (int) Math.round(Math.signum((this.getV() - o.getV()))); 
    }
    
    
}

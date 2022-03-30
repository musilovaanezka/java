/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoms2D;

/**
 *
 * @author Musilová
 */
public abstract class Geom2D implements Comparable<Geom2D> {
    public static Comparator<Geom2D> COMP_PLOCHA = new Comparator<>() {
        @override 
        public int compare(Geom2D o1, Geom2D o2) {
            if (o1.getPlocha() < o2.getPlocha) {
                return -1;
            }
            if (o1.getPlocha() > o2.getPlocha()) {
                return 1;
            }
            return 0;
        }
    }
    
    public abstract double getPlocha();
    public abstract double getObvod();

    @Override
    public int compareTo(Geom2D o) {
        double eps = 0.00001;
        if (this.getPlocha() < o.getPlocha()) return -1;        
        else if (Math.abs(this.getPlocha() - o.getPlocha()) < eps) return 0;
        else return 1;
    }
    
    public String getGeomParams() {
        return String.format("%f, %f ", getPlocha(), getObvod());
    }
    
}

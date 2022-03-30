/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoms3D;

/**
 *
 * @author Musilová
 */
class Kvadr implements Geom3D {
    
    private final double a;
    private final double b;
    private final double c;
    private final double s;
    private final double v;
    
    private Kvadr(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = (2 * a * b) + (2 * a * c) + (2 * b * c);
        this.v = a * b * c;
    }
    static Kvadr getInstance(double a, double b, double c) {
        return new Kvadr(a, b, c);
    }
    
    @Override
    public double getV() {
        return this.v;
    }
    
    @Override
    public double getP() {
        return this.s;
    }

    @Override
    public String toString() {
        return "Kvadr{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    
    
}

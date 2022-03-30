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
public class Trojuhelnik extends Geom2D {
    private final double a;
    private final double b;
    private final double c;

    public Trojuhelnik(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a + b < c || b + c < a || c + a < b){
            throw new IllegalArgumentException("Trojuhelnik nelze sestrojit");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPlocha() {
        double s = getObvod()/2;
        return Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }

    @Override
    public double getObvod() {
        return a + b + c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Trojuhelnik{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    
}

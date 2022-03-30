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
public class Obdelnik extends Geom2D {
    private final double a;
    private final double b;

    public Obdelnik(double a, double b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException("Neplatny rozmer" + a + "," + b);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getPlocha() {
        return a * b;
    }

    @Override
    public double getObvod() {
        return a + a + b + b;
    }

    @Override
    public String toString() {
        return "Obdelnik{" + "a=" + a + ", b=" + b + '}';
    }

    
    
    
}

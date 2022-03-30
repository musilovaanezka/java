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
public class Ctverec extends Geom2D{
    private final double a;
    private final double o;
    private final double s;

    public Ctverec(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Neplatny rozmer" + a);
        }
        this.o = 4 * a;
        this.s = a * a;
        this.a = a;
    }

    public double getA() {
        return a;
    }

    @Override
    public double getPlocha() {
        return this.s;
    }

    @Override
    public double getObvod() {
        return this.o;
    }

    @Override
    public String toString() {
        return "Ctverec{" + "a=" + a + '}';
    }

    

    
    
}

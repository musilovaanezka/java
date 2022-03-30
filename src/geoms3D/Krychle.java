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
class Krychle implements Geom3D {

    private final double a;
    private final double s;
    private final double v;
    
    private Krychle(double a) {
        this.a = a;
        this.v = a * a * a;
        this.s = 6 * a * a;
    }
    
    static Krychle getInstance(double a) {
        return new Krychle(a);
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
        return "Krychle{" + "a=" + a + '}';
    }
    
}

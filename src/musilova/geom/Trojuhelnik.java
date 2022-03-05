// atributy
//      strana a
//      strana b
//      strana c
package musilova.geom;

/**
 *
 * @author Musilová
 */
public class Trojuhelnik {
    private double a, b, c;
    
    public Trojuhelnik(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static Trojuhelnik getTrojuhelnik(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b) {
            return new Trojuhelnik(a, b, c);
        } 
        return null;
    }
    /**
     * getter strany a
     * @return double a
     */
    public double getA() {
        return this.a;
    }
    /**
     * getter strany b
     * @return double b
     */
    public double getB() {
        return this.b;
    }
    /**
     * getter strany c
     * @return double c
     */
    public double getC() {
        return this.c;
    }
    /**
     * obod trojuhelnika
     * @return double obvod
     */
    public double obvod() {
        return (a + b + c);
    }
    /**
     * obsah trojuhelnika
     * @return double obsah
     */
    public double obsah() {
        double st = this.a + this.b + this.c / 2;
        return Math.sqrt(st * (st - this.a) * (st - this.b) * (st - this.c));
    }
    public boolean jeRovnoramenny() {
        return (this.a == this.b || this.a == this.c || this.c == this.b);
    }
    public boolean jeRovnostranny() {
        return (this.a == this.b && this.b == this.c);
    }
    public boolean jePravouhly() {
        double c = nejvetsi(this.a, this.b, this.c);
        double cc = c * c;
        double ab2 = this.a * this.a + this.b * this.b + this.c * this.c - c * c;
        return ab2 == cc;
    }
    public boolean jeTupouhly() {
        double c = nejvetsi(this.a, this. b, this.c);
        double ab2 = this.a * this.a + this.b * this.b + this.c * this.c - c * c;
        double cc = c * c;
        return cc > ab2;
    }
    public boolean jeOstrouhly() {
        double c = nejvetsi(this.a, this. b, this.c);
        double ab2 = this.a * this.a + this.b * this.b + this.c * this.c - c * c;
        double cc = c * c;
        return cc < ab2;
    }
    private double nejvetsi(double a, double b, double c) {
        if (a > b && a > c) {
            return c;
        } else if (b > a && b > c) {
            return b;
        } else return c;
    }
    public static void main(String[] args) {
        Trojuhelnik t = new Trojuhelnik(1,2,3);
        System.out.println(t.getA());
        System.out.println(t.obvod());
        System.out.println(t.obsah());
        System.out.println(t.jeRovnostranny() ? "Je rovnostranny" : "Neni rovnostranny");
        System.out.println(t.jeRovnoramenny() ? "Je rovnoramenny" : "Neni rovnoramenny");
        System.out.println(t.jePravouhly() ? "Je pravouhly" : "Neni pravouhly");
        System.out.println(t.jeTupouhly() ? "Je tupouhly" : "Neni tupouhly");
        System.out.println(t.jeOstrouhly() ? "Je ostrouhly" : "Neni ostrouhly");
    }
}  

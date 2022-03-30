// knihovní trida
// metody - static 
//      soucet
//      soucin
//      rozdil
//      podil
package cv_03_2;

/**
 *
 * @author Musilová
 */
public final class Zlomky {
    private Zlomky () {}
    public static Zlomek soucet(Zlomek a, Zlomek b) {
        int cita = a.getCitatel();
        int jma = a.getJmenovatel();
        int citb = b.getCitatel();
        int jmb = b.getJmenovatel();
        int cit = cita * jmb + citb * jma;
        // riziko přetečení int 
        int jm = jma * jmb;
        return new Zlomek (cit,jm);
    }
    public static Zlomek soucin(Zlomek a, Zlomek b) {
        int cita = a.getCitatel();
        int jma = a.getJmenovatel();
        int citb = b.getCitatel();
        int jmb = b.getJmenovatel();
        return new Zlomek (cita * citb, jma * jmb);
    }
    public static Zlomek rozdil(Zlomek a, Zlomek b) {
        return soucet(a, b.getOpacny());
    }
    public static Zlomek podil(Zlomek a, Zlomek b) {
        return soucin(a, b.getPrevraceny());
    }
}

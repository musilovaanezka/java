/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.Calendary;

/**
 *
 * @author Musilová
 */
public class Kalendar {
    
    private int den;
    private int mesic;
    private int rok;
    private static final int[] pdvm = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] pdvmP = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    enum DenVTydnu {
        PONDELI, UTERY, STREDA, CTVRTEK, PATEK, SOBOTA, NEDELE
    }
    
    private Kalendar(int d, int m, int r) {
        den = d;
        mesic = m;
        rok = r;
    }
    
    public static Kalendar getInstance(int d, int m, int r) {
        if (d > 31 || d < 1 || m > 12 || m < 1) {
            throw new IllegalArgumentException("jeden nebo vice parametru byly zadany neplatne");
        }
        // kontrola dne v mesici
        if (m == 2 && d > 29) throw new IllegalArgumentException("je unor");
        if (m < 8 && m % 2 == 0 && m > 30) throw new IllegalArgumentException("tento mesic nema 31 dni");
        if (m > 8 && m % 2 != 0 && m > 30) throw new IllegalArgumentException("tento mesic nema 31 dni");
        
        return new Kalendar(d,m,r);
    }
    private static boolean PrestupnyRok(int r) {
        return ((r % 100) != 0 || (r % 400) == 0) && (r % 4 == 0);
    }
    private static int denVTydnu(int d, int m, int r) {
        
    } 
}

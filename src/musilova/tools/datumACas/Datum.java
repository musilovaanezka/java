/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.tools.datumACas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author Musilová
 */
public class Datum {

    private static LocalDate today = LocalDate.now();

    private static final int[] pdvm = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] pdvmP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int den;
    private int mesic;
    private int rok;

    private Datum(int den, int mesic, int rok) {
        this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }
    public Datum() {
        this.den = today.getDayOfMonth();
        this.mesic = today.getMonthValue();
        this.rok = today.getYear();
    }

    public static Datum getInstance(int d, int m, int r) {
        if (d > 31 || d < 1 || m > 12 || m < 1) {
            throw new IllegalArgumentException("jeden nebo vice parametru byly zadany neplatne");
        }
        // kontrola dne v mesici
        if (m == 2 && d > 29) {
            throw new IllegalArgumentException("je unor");
        }
        if (m < 8 && m % 2 == 0 && m > 30) {
            throw new IllegalArgumentException("tento mesic nema 31 dni");
        }
        if (m > 8 && m % 2 != 0 && m > 30) {
            throw new IllegalArgumentException("tento mesic nema 31 dni");
        }

        return new Datum(d, m, r);
    }

    public int vek(LocalDate narozeniny) {
        return Period.between(narozeniny, today).getYears();
    }

    public int vek(int den, int mesic, int rok) {
        return vek(prevod(den, mesic, rok));
    }

    public static LocalDate prevod(int den, int mesic, int rok) {
        return LocalDate.of(rok, mesic, den);
        
    }
    public static LocalDate prevod(Datum d) {
        return prevod(d.den, d.mesic, d.rok);
    }
    /**
     * metoda urcena pro zapis do souboru
     * @return String datum ve formatu den.mesic.rok;
     */
    @Override
    public String toString() {
        return "" + den + "." + mesic + "." + rok + ";";
    }
    
    public static void main(String[] args) {
        System.out.println(today.getMonthValue());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.tools.aktivity;

import musilova.tools.Uzivatel;

/**
 *
 * @author Musilová
 */
public class Vzdalenostni implements musilova.tools.Aktivita{
    private double minuty;
    private double vzdalenost;
    private int avHB;
    private musilova.tools.Uzivatel user;
    private int kcal;

    private Vzdalenostni(double minuty, double vzdalenost, int avHB, musilova.tools.Uzivatel user, int kcal) {
        this.avHB = avHB;
        this.minuty = minuty;
        this.kcal = kcal;
        this.user = user;
        this.vzdalenost = vzdalenost;
    }   
    /**
     * tvorba instance Vzdalenostni aktivity 
     * @param minuty double - doba cviceni v minutach
     * @param vzdalenost double - vzdalenost v km
     * @param avHB int - prumerna tepova frekvence
     * @param user Uzivatel - uzivatel, ktery aktivitu vykonaval
     * @return instance Vzdalenostni akivity 
     */
    public static Vzdalenostni getInstance(double minuty, double vzdalenost, int avHB, musilova.tools.Uzivatel user) {
        if (minuty < 0 || vzdalenost < 0 || avHB < 0 || avHB > 200 || user == null) {
            throw new IllegalArgumentException("nektery z udaju byl zadan chybne");
        }
        int kcal = (int) musilova.tools.Aktivita.kcalHByBPM(minuty, avHB, user);
        return new Vzdalenostni(minuty, vzdalenost, avHB, user, kcal); 
    }

    @Override
    public double getMinuty() {
        return this.minuty;
    }

    @Override
    public int getAvHB() {
        return this.avHB;
    }

    @Override
    public Uzivatel getUser() {
        return this.user;
    }

    @Override
    public int getKcal() {
        return this.kcal;
    }
    /**
     * getter pro vdalenost 
     * @return double vydalenost (km)
     */
    public double getVzd() {
        return this.vzdalenost;
    }
    /**
     * prepsana metoda toString()
     * urcena pro zapis do souboru
     * @return String minuty; prumerna tepova frekvence; vzdalenost; user.toString()
     */
    @Override
    public String toString() {
        return "Vzdalenostni;" + minuty + ";" + avHB + ";" + vzdalenost + ";";
    }
    /**
     * @return double[] {prumerna tepova frekvence, Kcal, minuty, vzdalenost} 
     */
    @Override
    public double[] getHodnoty() {
        return new double[]{getAvHB(), getKcal(), getMinuty(), getVzd()};
    }
    
    
}

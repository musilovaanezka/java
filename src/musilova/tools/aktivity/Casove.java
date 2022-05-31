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
public class Casove implements musilova.tools.Aktivita{
    private double minuty;
    private int avHB;
    private musilova.tools.Uzivatel user;
    private int kcal;

    private Casove(double minuty, int avHB, musilova.tools.Uzivatel user, int kcal) {
        this.avHB = avHB;
        this.minuty = minuty;
        this.kcal = kcal;
        this.user = user;
    }   
    public Casove(){
        
    }
    
    /**
     * tvorba instance Casove aktivity 
     * @param minuty double - doba cviceni v minutach
     * @param avHB int - prumerna tepova frekvence
     * @param user Uzivatel - uzivatel, ktery aktivitu vykonaval
     * @return instance Casove akivity 
     */
    public static Casove getInstance(double minuty, int avHB, musilova.tools.Uzivatel user) {
        if (minuty < 0 || avHB < 0 || avHB > 200 || user == null) {
            throw new IllegalArgumentException("nektery z udaju byl zadan chybne");
        }
        int kcal = (int) musilova.tools.Aktivita.kcalHByBPM(minuty, avHB, user);
        return new Casove(minuty, avHB, user, kcal); 
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
     * prepsana metoda toString()
     * urcena pro zapis do souboru
     * @return String Casove;minuty;prumerna tepova frekvence;user.toString()
     */
    @Override
    public String toString() {
        return "Casove;" + minuty + ";" + avHB + ";" + getKcal();
    }
    /**
     * @return double[] {prumerna tepova frekvence, Kcal, minuty} 
     */
    @Override
    public double[] getHodnoty() {
        return new double[]{getAvHB(), getKcal(), getMinuty()};
    }
}

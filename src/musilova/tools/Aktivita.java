/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.tools;

/**
 *
 * @author Musilová
 */
public interface Aktivita {
    /**
     * vypocet kcal spalenych na zaklade tepove frekvence 
     * @param minuty double - doba aktivity v minutach
     * @param bpm - int - prumerna tepova frekvence pri aktivite
     * @param user - Uzivatel uzivatel 
     * @return int kcal spalene v prubehu aktivity
     */
    public static double kcalHByBPM(double minuty, int bpm, Uzivatel user){
        double kcal = 0;
        switch (user.getPohlavi()) {
            case ZENA:
                kcal = minuty * (0.4472*user.getVyska() - 0.1263*user.getVaha() + 0.074*user.getVek() - 20.4022) / 4.184;
                break;
            case MUZ:
                kcal = minuty * (0.6309*user.getVyska() + 0.1988*user.getVaha() + 0.2017*user.getVek() - 55.0969) / 4.184;
                break;
            default: 
                double z = minuty * (0.4472*user.getVyska() - 0.1263*user.getVaha() + 0.074*user.getVek() - 20.4022) / 4.184;
                double m = minuty * (0.6309*user.getVyska() + 0.1988*user.getVaha() + 0.2017*user.getVek() - 55.0969) / 4.184;
                kcal = (z + m) / 2; 
        }
        return kcal;
    }
    /**
     * getter pro minuty
     * @return double minuty
     */
    public double getMinuty();
    /**
     * getter pro prumernou tepovou frekvenci 
     * @return int prumerna tepova frekvence
     */
    public int getAvHB();
    /**
     * getter pro uzivtele, ktery danou aktivitu vykonaval
     * @return Uzivatel uzivatel
     */
    public musilova.tools.Uzivatel getUser();
    /**
     * getter pro kcal spalene behem aktivity 
     * @return int Kcal
     */
    public int getKcal();
    /**
     * ziskani veskerych hodnot aktivity 
     * @return double[] hodnoty
     */
    public double[] getHodnoty();
}

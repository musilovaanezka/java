/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.zavody;

/**
 *
 * @author Musilová
 */
public class Zavodnik {
    private final String jmeno;
    private final String prijmeni;
    private final int rz;
    private final int rokNarozeni;
    private int casStartu = 0;
    private int casCile = 0;
    private int cas = vyhodnotCas();
    
    private static int RZ = 1;
    
    public Zavodnik(String jmeno, String prijmeni, int rokNarozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rokNarozeni = rokNarozeni;
        this.rz = pridelRZ();
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }    

    public int getRz() {
        return rz;
    }
    
    private static int pridelRZ() {
        return RZ++;
    }
    
    public void setCasStartu(int cas) {
        this.casStartu = cas;
    }
    
    public void setCasCile(int cas) {
        this.casCile = cas;
    }
    private int vyhodnotCas() {
        this.cas = this.casCile - this.casStartu;
        return this.cas;
    }
    
    public int getCas() {
        this.cas = vyhodnotCas();
        return this.cas;
    }
}

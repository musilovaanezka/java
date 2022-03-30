/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoby;

/**
 *
 * @author Musilová
 */
public class Osoba {
    private String jmeno;
    private String prijmeni;
    private final int rc;

    public Osoba(String jmeno, String prijmeni, int rc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rc = rc;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRc() {
        return rc;
    }

    @Override
    public String toString() {
        return "Osoba{" + "jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", rc=" + rc + '}';
    }
    
}

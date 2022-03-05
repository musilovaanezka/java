
package musilova.hra;

import java.util.Random;

/**
 *
 * @author Musilová
 */
public class MyslimSiCislo {

    private int cislo;
    private int pocetTipu;
    public final int dolniMez;
    public final int horniMez;
    private boolean konecHry;
    private static final Random rnd = new Random();

    public MyslimSiCislo() {
        this.dolniMez = 0;
        this.horniMez = 1000;
        this.cislo = rnd.nextInt(1000);
        this.konecHry = false;
        this.pocetTipu = 0;
    }

    public MyslimSiCislo(int horniMez) {
        this.dolniMez = 0;
        this.horniMez = horniMez;
        this.cislo = rnd.nextInt(horniMez);
        this.konecHry = false;
        this.pocetTipu = 0;
    }

    public MyslimSiCislo(int horniMez, int dolniMez) {
        this.horniMez = horniMez;
        this.dolniMez = dolniMez;
        cislo = rnd.nextInt(horniMez - dolniMez + 1) + dolniMez;
        this.konecHry = false;
        this.pocetTipu = 0;
    }
    /**
     * zpracovani tipu uzivatele
     * @param int tip 
     * @return int porovnani
     */
    public int porovnaniTipu(int t) {
        this.pocetTipu++;
        if (this.cislo > t) {
            return 1;
        } else if (this.cislo < t) {
            return -1;
        } else {
            this.konecHry = true;
            return 0;
        }
    }
    /**
     * getter pro informaci o konci hry
     * @return boolean konec hry
     */
    public boolean getKonecHry() {
        return this.konecHry;
    }
    /**
     * getter pro informaci o poctu tipu hrace
     * @return int pocet tipu
     */
    public int getPocetTipu() {
        return this.pocetTipu;
    }

}

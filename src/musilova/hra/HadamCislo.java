
package musilova.hra;


/**
 *
 * @author Musilová
 */
public class HadamCislo {
    public final int dolniMez;
    public final int horniMez;
    private int tempDolniMez;
    private int tempHorniMez;
    private boolean konecHry;
    private int pocetTipu;
    
    public HadamCislo() {
        this.horniMez = 1000;
        this.dolniMez = 0;
        this.tempDolniMez = 0;
        this.tempHorniMez = 1000;
        this.konecHry = false;
        this.pocetTipu = 0;
    }
    public HadamCislo(int horniMez) {
        this.horniMez = horniMez;
        this.dolniMez = 0;
        this.tempDolniMez = 0;
        this.tempHorniMez = horniMez;
        this.konecHry = false;
        this.pocetTipu = 0;
    }
    
    public HadamCislo(int horniMez, int dolniMez) {
        this.horniMez = horniMez;
        this.dolniMez = dolniMez;
        this.tempDolniMez = dolniMez;
        this.tempHorniMez = horniMez;
        this.konecHry = false;
        this.pocetTipu = 0;
    }
    /**
     * tip v polovine docasnych hranic 
     * zvyseni poctu tipu pocitace
     * @return int tip
     */
    public int getTip() {
        this.pocetTipu++;
        return ((this.tempHorniMez - this.tempDolniMez) / 2);        
    }
    /**
     * pocet tipu pocitace
     * @return int pocet tipu
     */
    public int getPocetTipu() {
        return pocetTipu;
    }
    /**
     * omezeni docasneho intervalu pro davani dalsiho tipu
     * na zaklade odpovedi hrace
     * ukonceni hry na zaklade odpovedi hrace
     * omezuje od tipu, ktery hlavnimu programu dala metoda getTip()
     * @param int odpoved hrace, zda byl tip vetsi, mensi, nebo odpovidajici
     * @param int tip ktery dala hlavnimu programu metoda getTip() 
     */
    public void vyhodnotitTip(int hl, int tip) {
        switch (hl) {
            case 1:
                this.tempDolniMez = tip;
                break;
            case -1:
                this.tempHorniMez = tip;
                break;
            case 0:
                this.konecHry = true;
            default:
                System.out.println("Neplatny vstup");
        }
    }
    /**
     * getter pro informaci, zda je jiz hra u konce
     * @return boolean konec hry
     */
    public boolean getKonecHry() {
        return konecHry;
    }
}

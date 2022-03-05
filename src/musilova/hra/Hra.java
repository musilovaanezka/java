package musilova.hra;

/**
 *
 * @author Musilová
 */ 

import musilova.hra.MyslimSiCislo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hra {

    private static final Scanner sc = new Scanner(System.in);
    
    public static int horniMez = 1000;
    public static int dolniMez = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
    }
    /**
     * vypis slovniho menu programu
     */
    private static void vypisMenu() {
        System.out.println("Slovni menu programu");
        System.out.println("1 - Pocitac Hada");
        System.out.println("2 - Hrac Hada");
        System.out.println("3 - Zmena nastaveni");
        System.out.println("0 - konec programu");
    }
    /**
     * nacteni uzivatelovy volby na zaklade vypsaneho menu programu
     * @return int volba
     */
    private static int nactiVolbu() {
        int volba;
        System.out.println("zadej volbu");
        try {
            volba = sc.nextInt();    
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }
    /**
     * obceny rozcestnik pro obsluhu volby
     * s metodami pro obsluhu jednotlivych voleb
     * @param volba z metody nactiVolbu()
     * @return boolean pokracovat v programu
     */
    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0 -> {
                return true;
            }
            case 1 -> pocitacHada();
            case 2 -> hracHada();
            case 3 -> zmenaNastaveni();
            default -> System.out.println("neznama volba");
        }
        return false;
    }
    /**
     * pocitac hada cislo, ktere si uzivatel mysli
     */
    private static void pocitacHada() {
        System.out.println("Budu hadat");
        // tvorba objektu hry
        HadamCislo hra = new HadamCislo(horniMez, dolniMez);
        // inicializace nutnych promennych
        int tip;
        int hl;
        // hra
        // do chvile kdy pocitac uhodne
        while (!hra.getKonecHry()) {
            tip = hra.getTip();
            
            // vypis otazky uzivateli 
            // volba uzivatele, jake cislo si myslel
            System.out.println(tip);
            System.out.println("");
            System.out.println("Trefil jsem se? -> 0");
            System.out.println("Bylo mensi? -> -1");
            System.out.println("Bylo vetsi? -> 1");
            
            // vyhodnoceni tipu
            hl = sc.nextInt();
            hra.vyhodnotitTip(hl, tip);
        }
        // vypis konce hry
        System.out.println("Hra je u konce");
        System.out.println("Muj celkovy pocet tipu: " + hra.getPocetTipu());
    }

    private static void hracHada() {
        System.out.println("Budes hadat");
        MyslimSiCislo hra = new MyslimSiCislo(horniMez, dolniMez);
        System.out.println("Hadej");
        int tip;
        int hl;
        while (!hra.getKonecHry()) {
            tip = sc.nextInt();
            hl = hra.porovnaniTipu(tip);
            switch (hl) {
                case 1: 
                    System.out.println("Vetsi");
                    break;
                case -1: 
                    System.out.println("Mensi");
                    break;
                case 0:
                    break;
                default: System.out.println("Neznamy vstup");
            }
        }
        System.out.println("Trefa!");
        System.out.println("Tvuj celkovy pocet tipu:" + hra.getPocetTipu());
    }
    private static void zmenaNastaveni() {
        // vypis menu pro zmenu nastaveni
        System.out.println("Horni mez: " + horniMez);
        System.out.println("Dilni mez: " + dolniMez);
        System.out.println("1 - zmena horni meze");
        System.out.println("2 - zmena dolni i horni meze");
        System.out.println("0 - zpet do hlavniho menu");
        // nacteni volby uzivatele
        int volba = sc.nextInt();
        
        int nove;
        // zpracovani volby uzivatele
        switch (volba) {
            case 1 -> { 
                System.out.println("zadej hodnotu nove horni meze");
                nove = sc.nextInt();
                if (nove < dolniMez) {
                    horniMez = dolniMez;
                    dolniMez = nove; 
                } else {
                    horniMez = nove;
                }                
            }
            case 2 -> {
                int noveH;
                int noveL;
                System.out.println("Zadej hodnotu nove horni meze");
                noveH = sc.nextInt();
                System.out.println("Zadej hodnotu nove dolni meze");
                noveL = sc.nextInt();
                if (noveH < noveL) {
                    dolniMez = noveH;
                    horniMez = noveL;
                } else {
                    dolniMez = noveL;
                    horniMez = noveH;
                }
                if (dolniMez == horniMez || dolniMez < 0) {
                    System.out.println("neplatne udaje");
                }
            }
            case 0 -> vypisMenu();
            default -> {
                System.out.println("neplatna volba"); 
                vypisMenu();
            }
        }
    }

    
}

package musilova;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Musilová
 */
public class kontrola {

    private static final Scanner sc = new Scanner(System.in);
    private static final char[] cifry
            = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

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
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("Hlavni menu programu");
        System.out.println("1. Prevod cisla z desitkove do jinesoustavy");
        System.out.println("2. Prevod cisla ze soustavy o zadanem z8klady do desitkove");
        System.out.println("3. Rozklad textoveho retezce s cestou k souboru na umisteni, nazev a priponu");
        System.out.println("4. Test textoveho retezce na palindrom, symetrie textoveho retezce");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }

    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0:
                return true;
            case 1:
                prevodZdesitkove();
                break;
            case 2:
                prevodDoDesitkove();
                break;
            case 3:
                umisteniNazevPriponaSouboru();
                break;
            case 4:
                testSymetrieTextovehoRetezce();
                break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
    }

    private static void prevodZdesitkove() {
        System.out.println("");
        System.out.println("Prevod cisla z desitkove soustavy do soustavy o jinem zakladu");
        // nacteni vstupu
        System.out.println("Zadej cislo v desitkove soustave (cele nezaporne cislo)");
        long cislo10 = sc.nextLong();
        System.out.println("Zadej zaklad soustavy do ktere prevest (cele cislo od 2 do " + cifry.length + ")");
        int zaklad = sc.nextInt();
        // kontrola vstupu
        if (cislo10 < 0) {
            System.out.println("Nelze provest prevod - cislo v desitkove soustave musi byt nezaporne");
            return;
        }
        if (zaklad < 2 || zaklad > cifry.length) {
            System.out.println("Nelze provest prevod - zaklad je mimo povoleny rozsah");
            return;
        }
        // provedeni pozadovane akce s platnymi hodnotami
        String cisloZ = "";
        do {
            int f = (int) (cislo10 % zaklad);
            cisloZ = cifry[f] + cisloZ;
            cislo10 /= zaklad;
        } while (cislo10 > 0);
        System.out.println("Cislo v jine soustave vypada jako: " + cisloZ);
    }

    private static void prevodDoDesitkove() {
        System.out.println("");
        System.out.println("Prevod cisla do desitkove soustavy");
        // nacteni vstupu
        System.out.println("Zadej zaklad soustavy ve ktere je zadane cislo");
        int zaklad = sc.nextInt();
        System.out.println("Zadej cislo");
        String cisloZ = sc.next();
        // kontrola platneho zakladu od 2 do cifry.length
        // kontrola cisla v zadane soustave 
        //   tj. - overit, zda textovy retezec obsahuje pouze povolene cifry
        // provedeni pozadovane akce s platnymi hodnotami 

    }

    private static void umisteniNazevPriponaSouboru() {
        System.out.println("");
        System.out.println("Zpracovani textoveho retezce obsahujiciho cestu k souboru");
        System.out.println("Analyza/separace umisteni, jmeno a pripona ze zadane cesty");
        // nacteni vstupu

        // provedeni pozadovane akce s platnymi hodnotami 
        
    }

    private static void testSymetrieTextovehoRetezce() {
        System.out.println("");
        System.out.println("Zpracovani textoveho retezce obsahujiciho cestu k souboru");
        System.out.println("Umisteni, jmeno a pripona ze zadane cesty");
        // nacteni vstupu
       
        // provedeni pozadovane akce s platnymi hodnotami 
        
    }

}

package musilova;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class musilova {

    private static final Scanner sc = new Scanner(System.in);
    private static final char[] cifry = 
    {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
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
    private static void vypisMenu() {
        System.out.println("Slovni menu programu");
        System.out.println("1 - prevod z 10 do jine dane soustavy");
        System.out.println("2 - prevod ze soustavy daneho zakladu do 10");
        System.out.println("3 - Rozklad textoveho retezce s cestou k souboru na umisteni, nazev a priponu");
        System.out.println("4 - Test textoveho retezce na palindrom, symetrie textoveho retezce");
        System.out.println("0 - konec programu");
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
            case 0: return true;
            case 1: prevodZ10(); break;
            case 2: prevodDo10(); break;
            //case 3: nazevSouboru(); break;
            //case 4: palindrom(); break;
            default: 
                System.out.println("neznama volba");
        }
        return false;
    }

    private static void prevodZ10() {
        System.out.println("do jake soustavy");
        int soustava = sc.nextInt(); 
        System.out.println("cislo");
        long cislo10 = sc.nextLong();
        // kontrola vstupu
        if (cislo10 < 0) {
            System.out.println("nelze prevest");
            return;
        }
        if (soustava < 2 || soustava > cifry.length) {
            System.out.println("nelze prevest");
            return;
        }
        // prevod
        String cislo = "";
        int f;
        do {
            f = (int) (cislo10 % soustava);            
            cislo = cifry[f] + cislo;
            cislo10 /= soustava;
        } while (cislo10 > 0);
        System.out.println(cislo);
    }

    private static void prevodDo10() {
        System.out.println("");
        System.out.println("z jake soustavy");
        int soustava = sc.nextInt(); 
        System.out.println("cislo");
        String cislo = sc.nextLine();
        int cislo10;
        for (int i = 0; i < cislo.length(); i++) {
            
        }
    }
}

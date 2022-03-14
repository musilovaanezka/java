/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musilova.cisla;

/**
 *
 * @author Musilová
 */ 

import java.util.InputMismatchException;
import java.util.Scanner;

public class KomplexniCislaTest {

    private static final Scanner sc = new Scanner(System.in);
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
        System.out.println("1 - soucet");
        System.out.println("2 - rozdil");
        System.out.println("3 - soucin");
        System.out.println("4 - podil");
        System.out.println("0 - konec programu");
    }
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
    private static boolean obsluzVolbu(int volba) {
        KomplexniCislo a = zadejCislo(); 
        KomplexniCislo b = zadejCislo(); 
        
        switch (volba) {
            case 0: return true;
            case 1: 
                System.out.println(secti(a, b)); 
                break;
            case 2: 
                System.out.println(odecti(a, b)); 
                break;
            case 3: 
                System.out.println(vynasob(a, b)); 
                break;
            case 4: 
                System.out.println(vydel(a, b)); 
                break;
            default: 
                System.out.println("neznama volba");
        }
        return false;
    }

    private static KomplexniCislo zadejCislo() {
        System.out.println("zadej komplexni cislo");
        return new KomplexniCislo(sc.nextLine());
    }
    private static KomplexniCislo secti(KomplexniCislo a, KomplexniCislo b) {
        return KomplexniCisla.soucet(a,b);
    }
    private static KomplexniCislo odecti(KomplexniCislo a, KomplexniCislo b) {
        return KomplexniCisla.rozdil(a,b);
    }
    private static KomplexniCislo vynasob(KomplexniCislo a, KomplexniCislo b) {
        return KomplexniCisla.soucin(a,b);
    }
    private static KomplexniCislo vydel(KomplexniCislo a, KomplexniCislo b) {
        return KomplexniCisla.podil(a,b);
    }
}

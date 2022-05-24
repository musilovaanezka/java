/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musilova.apps;

/**
 *
 * @author Musilová
 */ 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import musilova.tools.Aktivita;
import musilova.tools.Uzivatel;
import musilova.tools.Zaznamy;
import musilova.tools.aktivity.Casove;

public class SportovniAktivityApp {
    private static Uzivatel currentUser = null;
    private static final List<Uzivatel> users = new ArrayList<Uzivatel>(); 

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean konecProgramu = false;
        int volba;
        do {
            vypisMenu0();
            volba = nactiVolbu();
            konecProgramu = obsluzVolbu0(volba);
            if (konecProgramu) System.exit(0);
        } while (currentUser == null);
        do {
            vypisMenu1();
            volba = nactiVolbu();
            konecProgramu = obsluzVolbu1(volba);
        } while (!konecProgramu);
    }
    private static void vypisMenu0() {
        System.out.println("1 - novy uzivatel");
        System.out.println("0 - konec programu");
    }
    private static void vypisMenu1() {
        System.out.println("soubor aktualniho uzivatele: " + currentUser.getUserFile().toString());
        System.out.println("1 - novy uzivatel");
        System.out.println("2 - vyber uzivatele");
        System.out.println("3 - zapsat aktivitu");
        System.out.println("4 - vypis aktivit uzivatele");
        System.out.println("0 - konec programu");
    }
    private static void vypisMenu2() {
        System.out.println("soubor aktualniho uzivatele: " + currentUser.getUserFile().toString());
        System.out.println("Zapis aktivity -> vyber aktivity");
        System.out.println("1 - Casova aktivita");
        System.out.println("2 - Vzdalenostrni aktivita");
        System.out.println("0 - hlavni menu");
    }
    private static void vypisMenu3() {
        System.out.println("soubor aktualniho uzivatele: " + currentUser.getUserFile().toString());
        System.out.println("vypis aktivit uzivatele -> moznosti vypisu");
        System.out.println("1 - dle konkretniho data");
        System.out.println("2 - dle aktivity");
        System.out.println("3 - dle rozmezi dat");
        System.out.println("4 - dle rozmezi dat a aktivity");
        System.out.println("0 - hlavni menu");
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
    private static boolean obsluzVolbu0(int volba) throws IOException, InterruptedException {
        switch (volba) {
            case 1: 
                currentUser = tvorbaUzivatele(); 
                users.add(currentUser);
                return false;
            case 0: return true;
            default: System.out.println("neznama volba");
        }
        return false;
    } 
    private static boolean obsluzVolbu1(int volba) throws IOException, InterruptedException {
        switch (volba) {
            case 1: 
                tvorbaUzivatele(); 
                users.add(currentUser);
                break;
            case 2: vyberUzivatele(); break;
            case 3: 
                vypisMenu2();
                obsluzVolbu2(nactiVolbu());
                break;
            case 4: 
                vypisMenu3();
                obsluzVolbu3(nactiVolbu());
            default: 
                System.out.println("neznama volba");
        }
        return false;
    }
    private static void obsluzVolbu2(int volba) {
        switch(volba) {
            case 0: vypisMenu1();  break;
            case 1: tvorbaCasoveAktivity(); break;
            case 2: tvorbaVzdalenostrniAktivity(); break;
            default: System.out.println("neznama volba"); vypisMenu1();
        }    
    }
    private static void obsluzVolbu3(int volba) {
        switch(volba) {
            case 0: vypisMenu1(); break;
            case 1: vypisDleKonkretnihoData(); break;
            case 2: vypisDleAktivity(); break;
            case 3: vypisDleRozmeziDat(); break;
            case 4: vyspiDleRozmeziAAktivity(); break;
            default : System.out.println("neznama volba"); vypisMenu1();
        }
    }
    

    private static Uzivatel tvorbaUzivatele() throws IOException, InterruptedException {
        Uzivatel user;
        System.out.println("vek");
        int vek = sc.nextInt();
        System.out.println("vaha (kg)");
        double vaha = sc.nextDouble();
        System.out.println("vyska (cm)");
        int vyska = sc.nextInt();
        System.out.println("pohlavi: 1 - zena, 2 - muz, 3 - jine");
        try {
            Uzivatel.Pohlavi pohlavi = null;
            switch (sc.nextInt()) {
                case 1: pohlavi = Uzivatel.Pohlavi.ZENA; break;
                case 2: pohlavi = Uzivatel.Pohlavi.MUZ; break;
                case 3: pohlavi = Uzivatel.Pohlavi.JINE; break;
                default: throw new IllegalArgumentException("");
            }
            user = (Uzivatel.getInstance(vek, vaha, vyska, pohlavi));
            
        } catch (IllegalArgumentException ex) {
            System.out.println("nektera data nebyla zadana validne");
            return null;
        }
        return user;
    }

    private static void vyberUzivatele() {
        
    }

    private static void tvorbaCasoveAktivity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void tvorbaVzdalenostrniAktivity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void vypisDleKonkretnihoData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void vypisDleAktivity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void vypisDleRozmeziDat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void vyspiDleRozmeziAAktivity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

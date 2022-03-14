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

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZavodnikTest {

    static ArrayList<Zavodnik> zavodnici = new ArrayList<Zavodnik>();
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
        System.out.println("1 - Novy zavodnik");
        System.out.println("2 - vypis zavodniku");
        System.out.println("3 - vyhodnotit zavod");
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
        switch (volba) {
            case 0: return true;
            case 1: 
                Zavodnik zavodnik = registrace();
                casy(zavodnik);
                zavodnici.add(zavodnik);
                break;
            case 2: vypisZavodniky(); break;
            case 3: vyhodnotZavod(); break;
            default: 
                System.out.println("neznama volba"); 
                break;
        }
        return false;
    }

    private static Zavodnik registrace() {
        System.out.println("Jmeno");
        String jmeno = sc.nextLine();
        System.out.println("Prijmeni");
        String prijmeni = sc.nextLine();
        System.out.println("Rok narozeni");
        int rok = sc.nextInt();
        Zavodnik zavodnik = new Zavodnik(jmeno, prijmeni, rok);
        return zavodnik;
    }
    
    private static void casy(Zavodnik zavodnik) {
        System.out.println("zadej cas startu (v sekundach)");
        int casS = sc.nextInt();
        zavodnik.setCasStartu(casS);
        System.out.println("zadej cas cile (v sekundach)");
        int casC = sc.nextInt();
        zavodnik.setCasCile(casC);
    }

    private static void vypisZavodniky() {
        System.out.println("jake informace mam o zavodnicich vypsat?");
        System.out.println("1 - vsechny zname informace");
        System.out.println("2 - informace pri registraci");
        System.out.println("3 - registracni cisla zavodniku a jejich casy");
        System.out.println("0 - zpet do hlavniho menu");
        int volba = nactiVolbu();
        switch (volba) {
            case 0: vypisMenu(); break;
            case 1: vypisVsechInformaci(); break;
            case 2: vypisRegistraci(); break;
            case 3: vypisCiselACasu(); break;
        }
    }
    private static void vypisVsechInformaci() {
        Zavodnik zavodnik;
        for (int i = 0; i < zavodnici.size(); i++) {
            zavodnik = zavodnici.get(i);
            System.out.format("registrace: %d\t", zavodnik.getRz());
            System.out.format("jmeno: %s\t prijmeni: %s\n", zavodnik.getJmeno(), zavodnik.getPrijmeni());
            System.out.format("rok narozeni: %d\n cas: %d\n", zavodnik.getRokNarozeni(), zavodnik.getCas());
            System.out.println("");
        }
    }
    private static void vypisRegistraci() {
        Zavodnik zavodnik;
        for (int i = 0; i < zavodnici.size(); i++) {
            zavodnik = zavodnici.get(i);
            System.out.format("registrace: %d\t", zavodnik.getRz());
            System.out.format("jmeno: %s\t prijmeni: %s\n", zavodnik.getJmeno(), zavodnik.getPrijmeni());
            System.out.format("rok narozeni: %d\n", zavodnik.getRokNarozeni());
            System.out.println("");
        }
    }
    private static void vypisCiselACasu() {
        Zavodnik zavodnik;
        for (int i = 0; i < zavodnici.size(); i++) {
            zavodnik = zavodnici.get(i);
            System.out.format("registrace: %d\t", zavodnik.getRz());
            System.out.format("cas: %d s \n", zavodnik.getCas());
        }
    }
    private static void vyhodnotZavod() {
        int cas;
        int minCas = Integer.MAX_VALUE;
        Zavodnik zavodnik;
        Zavodnik vitez = zavodnici.get(0);
        for (int i = 0; i < zavodnici.size(); i++) {
            zavodnik = zavodnici.get(i);
            cas = zavodnik.getCas();
            if (cas < minCas) {
               minCas = cas;
               vitez = zavodnik;
            } 
        }
        System.out.format("Vyhral zavodnik cislo: %d\t s casem: %d", vitez.getRz(), minCas);
    }
}

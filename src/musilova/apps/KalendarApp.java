package musilova.apps;

import java.util.InputMismatchException;
import java.util.Scanner;
import musilova.datumcas.Kalendar;

/**
 *
 * @author Musilová
 */
public class KalendarApp {

    private static final Scanner sc = new Scanner(System.in);
    private static Kalendar kal = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisHlavniMenu();
            int volba = nacistVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
        System.out.println("Koncim ...");
    }

    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0 -> {
                return false;
            }
            case 1 -> nacistDatumVytvoritKalendar();
            case 2 -> vypsatAktualniDatumKalendare();
            case 3 -> vypsatMesicniKalendarVPodobeTabulky();
            case 4 -> listovaniVKalendari();
            default -> System.out.println("Zadana neplatna volba " + volba);
        }
        return false;
    }

    private static void vypisHlavniMenu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Vytvorit kalendar pro zadane datum");
        if (kal != null) {
            System.out.println("2. Vypsat aktualni datum kalendare");
            System.out.println("3. Vypsat tabulkovy kalendar aktualniho mesice");
            System.out.println("4. Listovani v kalendari");
        }
        System.out.println("0. Konec ");
    }

    private static int nacistVolbu() {
        int volba = -1;
        System.out.print("Zadej zvolenou polozku menu: ");
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException e) {
            // neplatna volba
            volba = -1;
        } finally {
            sc.nextLine();
        }
        return volba;
    }

    private static void nacistDatumVytvoritKalendar() {
        System.out.println("");
        try {
            System.out.print("Zadej den mesic a rok (hodnoty oddelene mezerou): ");
            int den = sc.nextInt();
            int mesic = sc.nextInt();
            int rok = sc.nextInt();
            kal = Kalendar.getInstance(den, mesic, rok);
        } catch (InputMismatchException ex) {
            System.out.println("Chyba pri zadavani ciselnych hodnot");
            System.out.println("Kalendar nebyl vytvoren, zkus to znovu");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            System.out.println("Zadane hodnoty nepredstavuji platne datum kalendare");
            System.out.println("Kalendar nebyl vytvoren, zkus to znovu");
            ex.printStackTrace();
        } finally {
            sc.nextLine();
        }
        if (kal != null) {
            System.out.println("Vytvoren kalendar, aktualni datum: " + kal.getDatumAsStr());
        }
    }

    private static void vypsatAktualniDatumKalendare() {
        System.out.println("");
        System.out.println("Vypis aktualniho datumu kalendare");
        System.out.println("V kalendari je " + kal.getDatumAsStr());
    }

    private static void vypsatMesicniKalendarVPodobeTabulky() {
        System.out.println("");
        System.out.println("Vypis tabulkoveho kalendare aktualniho mesice");
        System.out.format("Aktualni mesic: %02d/%d %n", kal.getMesic(), kal.getRok());
        System.out.println(kal.getMesicniKalendar());
    }

    private static void listovaniVKalendari() {
        System.out.println("");
        System.out.println("Listovani v kalendari, vyber datumu");
        Kalendar kalList = Kalendar.getInstance(kal);
        boolean konecListovani = false;
        do {
            System.out.format("Nalistovane datum: %s%n", kalList.getDatumAsStr());
            System.out.format("Nalistovany mesic: %02d/%d %n", kalList.getMesic(), kalList.getRok());
            System.out.println(kalList.getMesicniKalendar());
            System.out.println("Prikazy pro posun v kalendari zadej prikaz jako textovy retezec ve tvaru");
            System.out.println("  +d  -d  +t  -t  +m  -m  +r  -r  ok  storno");
            System.out.println(" +/-d/m/r - prikazy pro listovani po dnech, tydnech, mesicich a rocich");
            System.out.println(" ok       - vyber aktualniho datumu a navrat do hlavniho menu");
            System.out.println(" storno   - navrat do hlavniho menu bez zmeny aktualniho data");
            String volba = sc.next().toLowerCase();
            sc.nextLine();
            switch(volba) {
                case "+d": kalList.dalsiDen(); break;
                case "-d": kalList.predchoziDen(); break;
                case "+t": for(int i = 0; i < 7; i++) kalList.dalsiDen(); break;
                case "-t": for(int i = 0; i < 7; i++) kalList.predchoziDen(); break;
                case "+m": kalList.dalsiMesic(); break;
                case "-m": kalList.predchoziMesic();break;
                case "+r": kalList.dalsiRok(); break;
                case "-r": kalList.predchoziRok();break;
                case "ok": kal = kalList; konecListovani = true; break;
                case "storno" : konecListovani = true; break;
            } 
        } while (!konecListovani) ;
        

    }

}

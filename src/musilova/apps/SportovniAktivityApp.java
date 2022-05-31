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
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import musilova.tools.Uzivatel;
import musilova.tools.Zaznamy;

public class SportovniAktivityApp {

    private static Uzivatel currentUser = null;
    private static final List<Uzivatel> users = new ArrayList<Uzivatel>();

    private static final Scanner sc = new Scanner(System.in);
    private static final ResourceBundle rbCz = ResourceBundle.getBundle("musilova.props.popiskyCz", new Locale("cs", "CZ"));
    private static final ResourceBundle rbEn = ResourceBundle.getBundle("musilova.props.popiskyEn", Locale.UK);
    private static ResourceBundle rbAct = rbEn;

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
            if (konecProgramu) {
                System.exit(0); // lepsi by bylo nastavit konecProgramu na false :)
            }
        } while (currentUser == null);
        do {
            vypisMenu1();
            volba = nactiVolbu();
            konecProgramu = obsluzVolbu1(volba);
        } while (!konecProgramu);
    }

    private static void vypisMenu0() {
        System.out.println("1 - " + rbAct.getString("NewUser"));
        System.out.println("2 - " + rbAct.getString("LoadUser"));
        System.out.println("3 - " + rbAct.getString("LanguageChange"));
        System.out.println("0 - " + rbAct.getString("End"));
    }

    private static void vypisMenu1() {
        System.out.println(rbAct.getString("ActFile") + currentUser.getUserFile().toString()); // neosetrena vyjimka, kdyz je user null
        System.out.println("1 - " + rbAct.getString("NewUser"));
        System.out.println("2 - " + rbAct.getString("LoadUser"));
        System.out.println("3 - " + rbAct.getString("NewActivity"));
        System.out.println("4 - " + rbAct.getString("ExtractActivities"));
        System.out.println("5 - " + rbAct.getString("LanguageChange"));
        System.out.println("0 - " + rbAct.getString("End"));
    }

    private static void vypisMenu2() {
        System.out.println(rbAct.getString("ActFile") + currentUser.getUserFile().toString());
        System.out.println(rbAct.getString("menu2title"));
        System.out.println("1 - " + rbAct.getString("Act1"));
        System.out.println("2 - " + rbAct.getString("Act2"));
        System.out.println("0 - " + rbAct.getString("ToMain"));
    }

    private static void vypisMenu3() {
        System.out.println(rbAct.getString("ActFile") + currentUser.getUserFile().toString());
        System.out.println(rbAct.getString("menu3title"));
        System.out.println("1 - " + rbAct.getString("GivenDate"));
        System.out.println("2 - " + rbAct.getString("Activity"));
        System.out.println("3 - " + rbAct.getString("Days"));
        System.out.println("4 - " + rbAct.getString("DaysAndActivity"));
        System.out.println("0 - " + rbAct.getString("ToMain"));
    }

    private static int nactiVolbu() {
        int volba;
        System.out.println(rbAct.getString("EnterChoice"));
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
            case 1 -> {
                currentUser = tvorbaUzivatele();
                users.add(currentUser);
                return false;
            }
            case 2 -> {
                currentUser = nactiUzivatele();
                users.add(currentUser);
                return false;
            }
            case 3 -> {
                zmenaJazyka();
                return false;
            }
            case 0 -> {
                return true;
            }
            default ->
                System.out.println(rbAct.getString("UnknownChoice"));
        }
        return false;
    }

    private static boolean obsluzVolbu1(int volba) throws IOException, InterruptedException {
        switch (volba) {
            case 1 -> {
                currentUser = tvorbaUzivatele();
                users.add(currentUser);
            }
            case 2 -> {
                currentUser = nactiUzivatele();
                users.add(currentUser);
            }
            case 3 -> {
                vypisMenu2();
                obsluzVolbu2(nactiVolbu());
            }
            case 4 -> {
                vypisMenu3();
                obsluzVolbu3(nactiVolbu());
            }
            case 5 -> {
                zmenaJazyka();
            }
            default ->
                System.out.println(rbAct.getString("UnknownChoice"));
        }
        return false;
    }

    private static void obsluzVolbu2(int volba) {
        switch (volba) {
            case 0 ->
                vypisMenu1();
            case 1 ->
                tvorbaCasoveAktivity();
            case 2 ->
                tvorbaVzdalenostrniAktivity();
            default -> {
                System.out.println(rbAct.getString("UnknownChoice"));
                vypisMenu1();
            }
        }
    }

    private static void obsluzVolbu3(int volba) {
        switch (volba) {
            case 0 ->
                vypisMenu1();
            case 1 ->
                vypisDleKonkretnihoData();
            case 2 ->
                vypisDleAktivity();
            case 3 ->
                vypisDleRozmeziDat();
            case 4 ->
                vyspiDleRozmeziAAktivity();
            default -> {
                System.out.println(rbAct.getString("UnknownChoice"));
                vypisMenu1();
            }
        }
    }

    private static Uzivatel tvorbaUzivatele() throws IOException, InterruptedException {
        try {
            System.out.println(rbAct.getString("Age"));
            int vek = sc.nextInt();
            System.out.println(rbAct.getString("Weight"));
            double vaha = sc.nextDouble();
            System.out.println(rbAct.getString("Height"));
            int vyska = sc.nextInt();
            System.out.println(rbAct.getString("Sex"));
            int pohl = sc.nextInt();

            Uzivatel user = Zaznamy.tvorbaUzivatele(vek, vaha, vyska, pohl);
            if (user != null) {
                return user;
            } else {
                System.out.println(rbAct.getString("InvalidData"));
            }
            return user;
        } catch (Exception ex) {
            
        }   
        return null;
    }

    private static void tvorbaCasoveAktivity() {
        System.out.println(rbAct.getString("Duration"));
        double cas = sc.nextDouble();
        System.out.println(rbAct.getString("AvHb"));
        int avhb = sc.nextInt();
        System.out.println(rbAct.getString("Today"));
        System.out.println(rbAct.getString("YesNo"));
        int volba = nactiVolbu();
        try {
            switch (volba) {
                case 1 -> {
                    Zaznamy.zapisCasAktivity(cas, avhb, currentUser);
                }
                case 2 -> {
                    System.out.println(rbAct.getString("Date"));
                    Zaznamy.zapisCasAktivity(cas, avhb, currentUser, sc.nextInt(), sc.nextInt(), sc.nextInt());
                }
                default -> System.out.println(rbAct.getString("UnknownChoice"));
            }
        } catch (Exception ex) {
        }
    }

    private static void tvorbaVzdalenostrniAktivity() {
        System.out.println(rbAct.getString("Duration"));
        double cas = sc.nextDouble();
        System.out.println(rbAct.getString("AvHb"));
        int avhb = sc.nextInt();
        System.out.println(rbAct.getString("Distance"));
        double vzd = sc.nextDouble();
        System.out.println(rbAct.getString("Today"));
        System.out.println(rbAct.getString("YesNo"));
        int volba = nactiVolbu();
        try {
            switch (volba) {
                case 1 ->
                    Zaznamy.zapisVzdAktivity(cas, vzd, avhb, currentUser);
                case 2 -> {
                    System.out.println(rbAct.getString("Date"));
                    Zaznamy.zapisVzdAktivity(cas, vzd, avhb, currentUser, sc.nextInt(), sc.nextInt(), sc.nextInt());
                }
                default -> {
                    return;
                }
            }
        } catch (Exception ex) {
        }
    }

    private static void vypisDleKonkretnihoData() {
        System.out.println(rbAct.getString("TodaysActivities"));
        System.out.println(rbAct.getString("YesNo"));
        int volba = nactiVolbu();
        try {
            switch (volba) {
                case 1 ->
                    vypisZaznamy(Zaznamy.cteniZaznamuDleData(currentUser));
                case 2 -> {
                    System.out.println(rbAct.getString("Date"));
                    vypisZaznamy(Zaznamy.cteniZaznamuDleData(currentUser, volba, volba, volba));
                }
                default -> {
                    return;
                }
            }
        } catch (Exception ex) {
        }

    }

    private static void vypisZaznamy(List<String> zaznamy) {
        for (String s : zaznamy) {
            System.out.println(s);
        }
    }

    private static void vypisDleAktivity() {
        System.out.println(rbAct.getString(
                "ByWhichActivity")
                + "1 - " + rbAct.getString("Act1")
                + "2 - " + rbAct.getString("Act2"));
        String name = "";
        switch (nactiVolbu()) {
            case 1 ->
                name = "casove";
            case 2 ->
                name = "vzdalenostni";
        }
        try {
            vypisZaznamy(Zaznamy.cteniZaznamuDleAktivity(currentUser, name));
        } catch (Exception ex) {
        }
    }

    private static void vypisDleRozmeziDat() {
        System.out.println(rbAct.getString("StartDate"));
        System.out.println(rbAct.getString("EndDate"));
        try {
            vypisZaznamy(Zaznamy.cteniZaznamuOdDoData(currentUser,
                    sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        } catch (Exception ex) {
        }
    }

    private static void vyspiDleRozmeziAAktivity() {
        System.out.println(rbAct.getString("StartDate"));
        System.out.println(rbAct.getString("EndDate"));
        System.out.println(rbAct.getString("ByWhichActivity")
                + "1 -" + rbAct.getString("Act1")
                + "2 -" + rbAct.getString("Act2"));
        String name = "";
        switch (nactiVolbu()) {
            case 1 ->
                name = "casove";
            case 2 ->
                name = "vzdalenostni";
            default -> {
                System.out.println(rbAct.getString("UnknownChoice"));
                return;
            }
        }
        try {
            vypisZaznamy(Zaznamy.cteniZaznamuOdDoDleAktivity(currentUser,
                    sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next()));
        } catch (Exception ex) {
        }
    }

    private static Uzivatel nactiUzivatele() {
        System.out.println(rbAct.getString("Path"));
        String path = sc.nextLine();
        Uzivatel user = Zaznamy.nacteniUzivatele(path);
        if (user == null) {
            System.out.println(rbAct.getString("InvalidData"));
            return null;
        }
        return user;
    }

    private static void zmenaJazyka() {
        System.out.println("1 - " + rbAct.getString("En"));
        System.out.println("2 - " + rbAct.getString("Cz"));
        switch (nactiVolbu()) {
            case 1:
                rbAct = rbEn;
                break;
            case 2:
                rbAct = rbCz;
                break;
            default:
                System.out.println(rbAct.getString("UnknownChoice"));
        }
    }
}

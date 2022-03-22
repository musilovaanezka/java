/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.Polynomy;

/**
 *
 * @author Musilová
 */
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PolynomyApp {

    private static final Scanner sc = new Scanner(System.in);
    private static Polynom a;
    private static Polynom b;

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
        System.out.println("1 - zadani dvou polynomu");
        System.out.println("2 - soucet polynomu");
        System.out.println("3 - soucin polynomu");
        System.out.println("4 - hodnota polynomu");
        System.out.println("5 - derivace polynomu");
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
        Polynom c;
        switch (volba) {
            case 0:
                return true;
            case 1:
                a = zadejPolynom();
                b = zadejPolynom();
                break;
            case 2:
                c = Polynomy.soucet(a, b);
                System.out.println(c.toFmString());
                break;
            case 3:
                c = Polynomy.soucin(a, b);
                System.out.println(c.toFmString());
                break;
            case 4:
                double h;
                System.out.println("vyberte polynom (1 / 2)");
                switch (sc.next()){
                    case "1" -> {
                        h = hodnotaPolynomu(a);
                        System.out.println(h);
                }
                    case "2" -> {
                        h = hodnotaPolynomu(b);
                        System.out.println(h);
                }
                    default -> System.out.println("neznama volba");
                }

            case 5:
                System.out.println("vybete polynom (1 / 2)");
                switch (sc.next()) {
                    case "1" -> {
                        c = a.getDerivace();
                        System.out.println(c.toFmString());
                }
                    case "2" -> {
                        c = b.getDerivace();
                        System.out.println(c.toFmString());
                }
                    default -> System.out.println("neznama volba"); 
                }

            default:
                System.out.println("neznama volba");
        }
        return false;
    }

    private static Polynom zadejPolynom() {
        double[] p = new double[100];
        System.out.println("Zadavejte pouze koeficienty polynomu a to od nejnizsiho radu po nejvyssi");
        System.out.println("Zadavejte koeficienty do jakehokoli textoveho retezce");
        System.out.println("Maximalni pocet koeficientu: 100");
        System.out.println("Zadej polynom");
        int i = 0;
        while (sc.hasNextDouble()) {
            p[i] = sc.nextDouble();
            i++;
        }
        return Polynom.getPolynom(p);
    }
    private static double hodnotaPolynomu(Polynom p) {
        System.out.println("zadejte hodnotu x");
        double x = sc.nextDouble();
        return p.getHodnota(x);
    }

}

package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class HadaniCisla {

    private static final Scanner sc = new Scanner(System.in);
    private static int min;
    private static int max;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int pokusyA = 0;
        int pokusyB = 0;
        boolean opakovat = true;
        while (opakovat) {
            menu();
            switch (cislo()) {
                case 1:
                    minAMax();
                case 2:
                    switch (role()) {
                        case 1:
                            pokusyA += hadajici(min, max);
                            break;
                        case 2:
                            pokusyB += pocitacHada(min, max);
                            break;
                    }
                    break;
                case 3:
                    prubezneVysledky(pokusyA, pokusyB);
                    break;
                case 4:
                    prubezneVysledky(pokusyA, pokusyB);
                    vyhral(pokusyA, pokusyB);
                    opakovat = false;
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("1 - rozsah cisel");
        System.out.println("2 - role - hadajiciho / ridiciho)");
        System.out.println("3 - prubezne vysledky");
        System.out.println("4 - konec");
    }

    private static int role() {
        System.out.println("1 - hadajici");
        System.out.println("2 - ridici");
        int role = sc.nextInt();
        return role;
    }

    private static int cislo() {
        return sc.nextInt();
    }

    private static void minAMax() {
        System.out.println("minimum:");
        min = cislo();
        System.out.println("maximum:");
        max = cislo();
    }

    private static void prubezneVysledky(int pokusyA, int pokusyB) {
        System.out.format("pocitac:\t%d \nhrac:\t\t%d \n", pokusyB, pokusyA);
    }

    private static int nahodneCisloVRozmezi(int min, int max) {
        int hadaneCislo = (int) (Math.random() * (max + 1 - min));
        return (hadaneCislo + min);
    }

    private static int hadajici(int min, int max) {
        System.out.println("Hadej: ");
        int n = nahodneCisloVRozmezi(min, max);
        int pokusy = 1;
        int hada;
        while ((hada = sc.nextInt()) != n) {
            if (hada < n) {
                System.out.println("Hadane cislo je větší");
                pokusy++;
            } else {
                System.out.println("Hadane cislo je menší");
                pokusy++;
            }
        }
        System.out.println("Uhodl jsi!");
        return pokusy;
    }

    private static int pocitacHada(int min, int max) {
        boolean uhodnuto = false;
        int pokusy = 0;
        int lMin = min;
        int lMax = max;
        while (!uhodnuto) {
            int cislo = nahodneCisloVRozmezi(lMin, lMax);
            System.out.println(cislo);
            pokusy++;
            System.out.println("+ / - / = ?:");
            switch (sc.next()) {
                case "+":
                    lMin = cislo;
                    break;
                case "-":
                    lMax = cislo;
                    break;
                case "=":
                    uhodnuto = true;
            }
        }
        return pokusy;
    }

    private static void vyhral(int pokusyA, int pokusyB) {
        if (pokusyA > pokusyB) {
            System.out.println("Vyhral pocitac");
        } else if (pokusyA < pokusyB) {
            System.out.println("Vyhral hrac");
        } else {
            System.out.println("Remiza");
        }
    }

}

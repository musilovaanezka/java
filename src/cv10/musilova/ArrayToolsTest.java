package cv10.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class ArrayToolsTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean opakovat = true;
        while (opakovat) {
            menu();
            int volba = nactiInt();
            if (volba == 0) {
                opakovat = false;
                break;
            }
            
            System.out.println("Delka pole:");
            int delka = sc.nextInt();
            
            // metoda 19 se lisi svym vstupem
            // je nutne ji vyloucit mimo ostatni
            if (volba == 19) {
                System.out.println("max a min:");
                int max = sc.nextInt();
                int min = sc.nextInt();
                int[] b = ArrayTools.nahodnePole(delka, min, max);
                for (int i = 0; i < delka; i++) {
                    System.out.println(b[i]);
                }
                break;
            }          
            
            System.out.println("Hodnoty pole:");
            float[] a = nactiPole(delka);

            switch (volba) {
                case 1: 
                    System.out.println("n? (pokud ne = 0)");
                    int n = sc.nextInt();
                    if (n == 0) {
                        System.out.println("soucet = " + ArrayTools.soucet(a));
                    } else {
                        System.out.println("soucet = " + ArrayTools.soucet(a, n));
                    }
                    break;
                case 2:
                    System.out.println("n? (pokud ne = 0)");
                    n = sc.nextInt();
                    if (n == 0) {
                        System.out.println("soucin = " + ArrayTools.soucin(a));
                    } else {
                        System.out.println("soucin = " + ArrayTools.soucin(a, n));
                    }
                    break;
                case 3:
                    System.out.println("maximum = " + ArrayTools.max(a));
                    break;
                case 4:
                    System.out.println("minimum = " + ArrayTools.min(a));
                    break;
                case 5:
                    System.out.println("index prvniho vyskytu maxima = " + ArrayTools.prvniMax(a));
                    break;
                case 6:
                    System.out.println("index posledniho vyksytu maxima = " + ArrayTools.posledniMax(a));
                    break;
                case 7:
                    System.out.println("index prvniho vyskytu minima = " + ArrayTools.prvniMin(a));
                    break;
                case 8:
                    System.out.println("index posledniho vyskytu minima = " + ArrayTools.posledniMin(a));
                    break;
                case 9:
                    System.out.println("n? (pokud ne = 0)");
                    n = sc.nextInt();
                    System.out.println("hledana hodnota =");
                    float b = sc.nextFloat();
                    if (n == 0) {
                        System.out.println("pocet vyskytu = " + ArrayTools.pocetVyskytu(a, n, b));
                    } else {
                        System.out.println("pocet vyskytu = " + ArrayTools.pocetVyskytu(a, b));
                    }
                    break;
                case 10:
                    System.out.println("pocet sudych hodnot = " + ArrayTools.pocetSudych(a));
                    break;
                case 11:
                    System.out.println("pocet lichych hodnot = " + ArrayTools.pocetLichych(a));
                    break;
                case 12:
                    System.out.println("hodnota = ");
                    System.out.println("index prvniho vyskytu = " + ArrayTools.prvniVyskyt(a, sc.nextFloat()));
                    break;
                case 13:
                    System.out.println("hodnota = ");
                    System.out.println("index posledniho vyskytu = " + ArrayTools.posledniVyskyt(a, sc.nextFloat()));
                    break;
                case 14:
                    System.out.println((ArrayTools.vzestupne(a) ? "je vzestupne setridene" : "neni vzestupne setridene"));
                    break;
                case 15:
                    System.out.println((ArrayTools.sestupne(a) ? "je seestupne setridene" : "neni seestupne setridene"));
                    break;
                case 16:
                    System.out.println((ArrayTools.stridavaPosloupnost(a)? "je stridave" : "neni stridave"));
                    break;
                case 17:
                    float[] c = ArrayTools.getReversed(a);
                    for (int i = 0; i < c.length; i++) {
                        System.out.println(c[i]);
                    }                                       
                case 18: 
                    ArrayTools.reverse(a);
                    for(int i = 0; i < a.length; i++) {
                        System.out.println(a[i]);
                    }
                case 19:
                default: System.out.println("neplatný údaj"); break;
            }
        }
    }
    private static void menu() {
        System.out.println("1   soucet cele pole / prvnich n prvku");
        System.out.println("2   soucin cele pole /prvnich n prvku");
        System.out.println("3   maximalni hodnota");
        System.out.println("4   minimalni hodnota");
        System.out.println("5   prvni vyskyt maxima");
        System.out.println("6   posledni vyskyt maxima");
        System.out.println("7   prvni vyskyt minima");
        System.out.println("8   posledni vyskyt minima");
        System.out.println("9   pocet vyskytu dane hodnoty v poli / mezi prvnimi n prvky");
        System.out.println("10  pocet sudych hodnot");
        System.out.println("11  pocet lichych hodnot");
        System.out.println("12  prvni vyskyt dane hodnoty");
        System.out.println("13  posledni vyskyt dane hodnoty");
        System.out.println("14  je pole vzestupne setridene?");
        System.out.println("15  je pole sestupne setridene?");
        System.out.println("16  je pole stridavou posloupnosti?");
        System.out.println("17  nove prevracene pole");
        System.out.println("18  prevraceni pole");
        System.out.println("19  pole nahodnych hodnot");
        System.out.println("0   konec");
    }
    private static int nactiInt() {
        return sc.nextInt();
    }
    private static float[] nactiPole(int delka) {
        float[] a = new float[delka];
        for (int i = 0; i < delka; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}

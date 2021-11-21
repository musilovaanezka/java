package musilova;

import java.util.Scanner;
import static musilova.DateTimeTools.prestupnyRok;

/**
 *
 * @author Musilová
 */
public class DateTimeToolsTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean opakovat = true;
        int volba, rok, mesic, den, hodiny, minuty, sekundy;
        float hodnota;
        String jednotka;
        while (opakovat) {
            menu();
            volba = nactiInt();
            switch (volba) {
                case 1:
                    System.out.println("Rok:");
                    System.out.println(prestupnyRok(nactiInt()) ? "Je prestupny" : "Neni prestupny");
                    break;
                case 2:
                    System.out.println("Rok:");
                    rok = nactiInt();
                    System.out.println("Mesic:");
                    mesic = nactiInt();
                    System.out.println("Den:");
                    den = nactiInt();
                    System.out.println(DateTimeTools.platnostData(rok, mesic, den) ? "Je platne" : "Neni platne");
                    break;
                case 3:
                    System.out.println("Hodiny:");
                    hodiny = nactiInt();
                    System.out.println("Minuty:");
                    minuty = nactiInt();
                    System.out.println("Sekundy:");
                    sekundy = nactiInt();
                    System.out.println(DateTimeTools.platnostCasu(hodiny, minuty, sekundy) ? "Je platny" : "Neni platny");
                    break;
                case 4:
                    System.out.println("Rok:");
                    rok = nactiInt();
                    System.out.println("Mesic:");
                    mesic = nactiInt();
                    System.out.println("Pocet dni v mesici = " + DateTimeTools.pocetDniMesice(rok, mesic));
                    break;
                case 5:
                    System.out.println("Rok:");
                    rok = nactiInt();
                    System.out.println("Mesic:");
                    mesic = nactiInt();
                    System.out.println("Den:");
                    den = nactiInt();
                    System.out.println("Cislo dne v tydnu = " + DateTimeTools.cisloDneVTydnu(rok, mesic, den));
                    break;
                case 6:
                    System.out.println("Rok:");
                    rok = nactiInt();
                    System.out.println("Mesic:");
                    mesic = nactiInt();
                    System.out.println("Den:");
                    den = nactiInt();
                    System.out.println("Den v tydnu = " + DateTimeTools.denVTydnu(rok, mesic, den));
                    break;
                case 7:
                    System.out.println("Hodiny:");
                    hodiny = nactiInt();
                    System.out.println("Minuty:");
                    minuty = nactiInt();
                    System.out.println("Sekundy:");
                    sekundy = nactiInt();
                    System.out.println("Jednotka (d / h / m / s):");
                    jednotka = sc.next();
                    System.out.println("= " + DateTimeTools.casNaHodnotu(jednotka, hodiny, minuty, sekundy));
                    break;
                case 8:
                    System.out.println("Hodnota:");
                    hodnota = sc.nextFloat();
                    System.out.println("Jednotka:");
                    jednotka = sc.next();
                    int[] cas = DateTimeTools.hodnotaNaCas(jednotka, hodnota);
                    for (int i = 0; i < cas.length; i++) {
                        System.out.println(cas[i]);
                    }
                    break;
                case 0:
                    opakovat = false;
            }
        }
    }

    private static void menu() {
        System.out.println("1 - Test prestupnesho roku");
        System.out.println("2 - Platnost data");
        System.out.println("3 - Platnost casu");
        System.out.println("4 - Pocet dni mesice");
        System.out.println("5 - Cislo dne v tydnu (0 = sobota)");
        System.out.println("6 - Jmeno dne v tydnu");
        System.out.println("7 - Prevod casu na jednu hodnotu");
        System.out.println("8 - Prevod jedne hodnoty na cas");
        System.out.println("0 - konec");

    }

    private static int nactiInt() {
        return sc.nextInt();
    }
}

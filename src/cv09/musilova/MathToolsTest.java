package cv09.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class MathToolsTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean opakovat = true;
        double x = 0;
        double eps = 0;
        while (opakovat) {
            menu();
            int volba = nactiInt();
            switch (volba) {
                case 0: opakovat = false; break;
                case 1: 
                    System.out.println("a = ");
                    x = sc.nextDouble();
                    System.out.println("n = ");
                    int n = nactiInt();
                    System.out.println("a na n = " + MathTools.aNaN(x, n));
                    break;
                case 2:
                    System.out.println("x = ");
                    x = sc.nextDouble();
                    System.out.println("eps = ");
                    eps = sc.nextDouble();
                    System.out.println("sin(x) = " + MathTools.sin(x, eps));
                    break;
                case 3:
                    System.out.println("x = ");
                    x = sc.nextDouble();
                    System.out.println("eps = ");
                    eps = sc.nextDouble();
                    System.out.println("ln(x) = " + MathTools.ln(x, eps));
                    break;
                case 4: 
                    System.out.println("x = ");
                    x = sc.nextDouble();
                    System.out.println("eps = ");
                    eps = sc.nextDouble();
                    System.out.println("odmocnina z x = " + MathTools.sqrt(x, eps));
                    break;
                case 5:
                    System.out.println("x = ");
                    n = sc.nextInt();
                    System.out.println("Faktorial x = " + MathTools.fakt(n));
                    break;
            }
        }
    }
    public static void menu() {
        System.out.println("1 - mocina (a na n)");
        System.out.println("2 - sin(x)");
        System.out.println("3 - ln(x)");
        System.out.println("4 - odmocina");
        System.out.println("5 - faktorial");
        System.out.println("0 - konec");
    }
    public static int nactiInt() {
        return sc.nextInt();
    }

}

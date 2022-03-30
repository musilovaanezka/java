package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PrvocisloMetoda {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Cislo k testu");
        int n = sc.nextInt();
        System.out.format("Cislo %d %d prvoslislo %n", n, jePrvocislo(n) ? "je" : "neni");
    }
    
    private static boolean jePrvocislo(int n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        for (int k = 3; k <= n/2; k++) {
            if (n % k == 0) {
                return false;
            }
        }
        return true;
    }
}

package cv09.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class StejnePoctyCifer {

    private static final Scanner sc = new Scanner(System.in);
    private static int MAX = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // dvojice int
        // do 0 / záp
        // záp - 2. hodnota -> chybne zadani
        long a;
        long b;
        int[] alpha;
        int[] beta;
        boolean opakovat = true;
        
        while (opakovat) {
            System.out.println("Cislo 1: ");
            a = sc.nextLong();
            System.out.println("Cislo 2: ");
            b = sc.nextLong();
            
            if (a <= 0) {
                opakovat = false;
            }
            if (b <= 0) {
                System.out.println("neplatna hodnota");
                break;
            }
            alpha = cifry(a);
            beta = cifry(b);
            
            System.out.println((porovnani(alpha, beta) ? "Maji stejne pocty" : "Nemaji stejne pocty"));
        }   
    }
    // metoda pro zjisteni poctu cifer 
    private static int[] cifry(long cislo) {
        int[] cifry = new int[MAX];
        byte cifra;
        while(cislo != 0) {
            cifra = (byte) (cislo % 10);
            cifry[cifra]++;
            cislo = cislo / 10;
        }
        return cifry;
    }
    //metoda pro porovnani dvou poli
    private static boolean porovnani(int[] a, int[] b) {
        boolean stejne = false;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                stejne = true;
            }
        }
        return stejne;
    }
}

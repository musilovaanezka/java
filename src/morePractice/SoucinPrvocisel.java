package morePractice;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class SoucinPrvocisel {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("cislo:");
        int n = sc.nextInt();
        int m;
        
        for (int i = 2; i <= n/2; i++) {
            while (n % i == 0) {
                m = n / i;
                n -= m;
                System.out.println(i);
            }
            if (i == n/2) {
                System.out.format("%d %n %d %n", 1, n);
            }
        }
    }

}

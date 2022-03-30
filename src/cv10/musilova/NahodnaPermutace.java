package cv10.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class NahodnaPermutace {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    private static int[] vytvorNahodnouPermutaci(int n) {
        System.out.println("n = ");
        int[] b = new int[n - 1];
        int r = 0; 
        for (int i = 0; i < n - 1; i++) {
            b[i] = i;            
        }
        for (int i = 0; i < b.length; i++)
            r = (int)(Math.random() * (n));
            int temp = b[i];
            b[i] = b[r];
            b[r] = temp;
    }
}

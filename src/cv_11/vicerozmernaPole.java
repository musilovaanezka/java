package cv_11;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class vicerozmernaPole {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       double[][] A = nactiMatici();
       double[][] B = nactiMatici();
    }
    private static double[][] nactiMatici(){
        System.out.println("pocet radku a sloupcu");
        int pr = sc.nextInt();
        int ps = sc.nextInt();
        double[][] a =new double[pr][ps];
        System.out.println("prvky:");
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        return a;
    }
    private static void vypisMatici(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextDouble();
                System.out.format("%8.2f ", a[i][j]);
            }
        }
        System.out.println();
    }
}

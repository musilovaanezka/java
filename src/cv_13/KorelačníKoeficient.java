package cv_13;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class KorelačníKoeficient {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("pocet dvojic:");
        int pDvojic = sc.nextInt();
        double[][] xy = new double[2][pDvojic];
        System.out.println("dvojice:");
        for(int i = 0; i < pDvojic; i++) {
                xy[0][i] = sc.nextDouble();
                xy[1][i] = sc.nextDouble();
        }
    }
    public static double[] aritmetickyPrumerXY(double[][] a) {
        double[] p = new double[2];
        double suma = 0;
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < a[0].length; j++) {
                 suma += a[i][j]; 
            }
            p[i] = suma / a[0].length; 
            suma = 0;
        }
        return p;
    }

}

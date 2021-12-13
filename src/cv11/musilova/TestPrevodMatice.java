package cv11.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class TestPrevodMatice {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] A = nactiMatici();
        A = MatrixTools.normalizace(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + "   ");
            }
            System.out.println("");
        }
    }
    private static double[][] nactiMatici(){
        System.out.println("radky a sloupce:");
        int radky = sc.nextInt();
        int sloupce = sc.nextInt();
        double[][] a =new double[radky][sloupce];
        System.out.println("prvky:");
        for (int i = 0; i < radky; i++) {
            for (int j = 0; j < sloupce; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        return a;
    }
}

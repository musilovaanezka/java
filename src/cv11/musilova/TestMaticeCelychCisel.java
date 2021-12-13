package cv11.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class TestMaticeCelychCisel {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] A = nactiMatici();
        System.out.println(MatrixTools.soumerna(A) ? "Je" : "Neni");
        System.out.println((MatrixTools.soucty(A) ? "Má" : "Nema") + " stejne sousty");
    }
    private static int[][] nactiMatici(){
        System.out.println("radky a sloupce:");
        int radky = sc.nextInt();
        int sloupce = sc.nextInt();
        int[][] a = new int[radky][sloupce];
        System.out.println("prvky:");
        for (int i = 0; i < radky; i++) {
            for (int j = 0; j < sloupce; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }
}

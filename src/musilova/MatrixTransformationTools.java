
package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class MatrixTransformationTools {
    
    //private static final Scanner sc = new Scanner(System.in);
    
    //public static void main(String[] args) {
    //    int[][] matice = new int[3][4];
    //    int prvek = 1;
    //    for (int i = 0; i < matice.length; i++) {
    //        for (int j = 0; j < matice[i].length; j++) {
    //            matice[i][j] = prvek;
    //            prvek ++;
    //        }
    //    }
    //    vytiskMatice(matice);
    //    matice = transpozice(matice);
    //    vytiskMatice(matice);
    //    prevraceniVertikalne(matice);
    //    vytiskMatice(matice);
    //    prevraceniHorizontalne(matice);
    //    vytiskMatice(matice);
    //    matice = rotaceO90PoSmeru(matice);
    //    vytiskMatice(matice);
    //    matice = rotaceO90ProtiSmeru(matice);
    //    vytiskMatice(matice);
    //    
    //}
    //public static void vytiskMatice(int[][] a) {
    //    for (int i = 0; i < a.length; i++) {
    //        for (int j = 0; j < a[i].length; j++) {
    //            System.out.print(a[i][j] + " ");
    //        }
    //            System.out.println("");
    //    }
    //    System.out.println("");
    //}
    
    
    /**
     * transpozice matice celych cisel
     * @param int[][]
     * @return int[][]
     */
    public static int[][] transpozice(int[][] a) {
        int ps = a[0].length;
        int pr = a.length;
        int[][] b = new int[ps][pr];
        for (int i = 0; i < ps; i++) {
            for (int j = 0; j < pr; j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }
    /**
     * vertikalni prevraceni matice celych cisel
     * @param int[][]
     * @return int[][]
     */
    public static void prevraceniVertikalne(int[][] a) {
        int ps = a[0].length;
        int pr = a.length;
        int temp;
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps/2; j++) {
                temp = a[i][j];                
                a[i][j] = a[i][ps - j - 1];              
                a[i][ps - j - 1] = temp;
            }
        }
    }
    /**
     * prevraceni matice dle horizontalni osy
     * @param int[][]
     */
    public static void prevraceniHorizontalne(int[][] a) {
        int ps = a[0].length;
        int pr = a.length;
        int temp;
        for (int i = 0; i < ps; i++) {
            for (int j = 0; j < pr/2; j++) {
                temp = a[j][i];
                a[j][i] = a[pr - j - 1][i];
                a[pr - j - 1][i] = temp;
            }
        }
    }
    /**
     * rotace matice celych cisel 
     * o 90 stupnu v kladnem smeru
     * @param int[][]
     * @return int[][]
     */
    public static int[][] rotaceO90PoSmeru(int[][] a) {
        int ps = a[0].length;
        int pr = a.length;
        int[][] b = new int[ps][pr];
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                b[j][pr - 1 - i] = a[i][j];
            }
        }
        return b;
    }
    /**
     * rotace matice celych cisel 
     * o 90 stupnu v zapornem smeru
     * @param int[][]
     * @return int[][]
     */
    public static int[][] rotaceO90ProtiSmeru(int[][] a) {
        int ps = a[0].length;
        int pr = a.length;
        int[][] b = new int[ps][pr];
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                b[ps - 1 - j][i] = a[i][j];
            }
        }
        return b;
    }
}

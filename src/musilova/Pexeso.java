package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Pexeso {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] p = PexesoTools.poleRozlozeniKaret(5, 5, 12);
        matice(p);
        
        int pocetChyb = 0;
        for (int i = 0; i < 100; i++) {
            p = PexesoTools.poleRozlozeniKaret(100, 100, 5000);
            if (!PexesoTools.maticeProPexeso(p, 5000)) {
                pocetChyb++;
            }
        }
        System.out.println("pocet chybne vygenerovanych matic = " + pocetChyb);
    }
    private static void matice(int[][] a) {
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}

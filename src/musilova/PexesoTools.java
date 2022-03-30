/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova;

import java.util.Random;


/**
 *
 * @author Musilová
 */
public class PexesoTools {
    
    private static final Random rnd = new Random();
    
    private PexesoTools() {
    }
    public static int[][] poleRozlozeniKaret(int r, int s, int n) {
        if (2*n > r * s) return null;
        int[][] A = new int[r][s];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int rpos = rnd.nextInt(r);
                int spos = rnd.nextInt(s);
                while (A[rpos][spos] != 0) {
                    spos++;
                    if (spos >= s) {
                        rpos++;
                        spos = 0;
                    }
                    if (rpos >= r) {
                        rpos = 0;
                        spos = 0;
                    }
                }
                A[rpos][spos] = i;
            }
        }
        
        return A;
    }
    public static int[][] poleRozlozeniKaret2(int r, int s, int n) {
        if (2*n > r * s) return null;
        int[][] A = new int[r][s];
        int poradi = 0 ;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                int k = poradi/2 + 1;
                A[i][j] = k;
                poradi++;
            }
        }
        return A;
    }
    public static boolean maticeProPexeso(int[][] a, int n) {
        
    }
    public static double prumernaVzdalenostDvojicKaret() {
    
    }
}

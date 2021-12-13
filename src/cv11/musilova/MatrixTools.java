/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv11.musilova;

/**
 *
 * @author Musilová
 */
public class MatrixTools {

    public static double[][] soucetMatic(double[][] a, double[][] b) {
        // matice musi byt stejnych rozmeru
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; i++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static double[][] soucinMatic(double[][] a, double[][] b) {
        if (b.length != a[0].length) {
            return null;
        }
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k > b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    private static double maxAbs(double[][] a) {
        double maxAbs = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (Math.abs(a[i][j]) > maxAbs) {
                    maxAbs = a[i][j];
                }
            }
        }
        return maxAbs;
    }

    public static double[][] normalizace(double[][] a) {
        double maxAbs = maxAbs(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] /= maxAbs;
            }
        }
        return a;
    }

    public static boolean soumerna(int[][] a) {        
        if (ctvercovaMatice(a) == false) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean soucty(int[][] a) {
        if (ctvercovaMatice(a) == false) {
            return false;
        }
        int sumaR = 0;
        for (int i = 0; i < a[0].length; i++) {
            sumaR += a[0][i];
        }
        int sumaS = 0;
        for (int i = 0; i < a.length; i++) {
            sumaS += a[i][0];
        }
        int sumaD1 = 0;
        int sumaD2 = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == j) {
                    sumaD1 += a[i][j];  
                }
                if(i + j == a.length) {
                    sumaD2 += a[i][j];
                }
            }
        }
        if (sumaD1 != sumaD2) { return false; }
        if (sumaR != sumaS) { return false; }
        if (sumaR != sumaD1) { return false; }
        return true;
    }
    private static boolean ctvercovaMatice(int[][] a) {
        return a.length == a[0].length;
    }
}

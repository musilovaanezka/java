/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv10.musilova;

/**
 *
 * @author Musilová
 */
public class ArrayTools {
    /**
     * soucet prvku pole
     * @param float[]
     * @return float sum
     */
    public static float soucet(float[] a){
        float sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    /**
     * soucet prvnich n prvku pole
     * @param float[]
     * @param n
     * @return float sum 
     */
    public static float soucet(float[] a, int n){
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum;
    }
    /**
     * soucin vsech prvku pole
     * @param float[]
     * @return float soucin
     */
    public static float soucin(float[] a){
        float scin = 1;
        for(int i = 0; i < a.length; i++) {
            scin *= a[i];
        }
        return scin;
    }
    /**
     * soucin prvnich n prvku pole
     * @param float[]
     * @param n
     * @return float soucin
     */
    public static float soucin(float[] a, int n) {
        float scin = 1;
        for(int i = 0; i < n; i++) {
            scin *= a[i];
        }
        return scin;
    }
    /**
     * hodnota prvku s maximalni hodnotou v ramci pole
     * @param float[]
     * @return float max
     */
    public static float max(float[] a) {
        float max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
    /**
     * hodnota prvku s minimalni hodnotou v ramci pole
     * @param float[]
     * @return float min
     */
    public static float min(float[] a) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;    
    }
    /**
     * index prvniho vyskytu maximalni hodnoty v ramci pole
     * @param float[]
     * @return int index
     */
    public static int prvniMax(float[] a) {
        float max = max(a);
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                index = i;
            }
        }
        return index;
    }
    /**
     * index posledniho vyskytu maximalni hodnoty v ramci pole
     * @param float[]
     * @return int index
     */
    public static int posledniMax(float[] a) {
        float max = max(a);
        int index = 0;
        for (int i = a.length; i > 0; i--) {
            if (a[i] == max) {
                index = i;
            }
        }
        return index;
    }
    /**
     * index prvniho vyskytu minimalni hodnoty v ramci pole
     * @param float[]
     * @return int index
     */
    public static int prvniMin(float[] a) {
        float min = min(a);
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) {
                index = i;
            }
        }
        return index;    
    }
    /**
     * index posledniho vyskytu minimali hodnoty v ramci pole
     * @param float[]
     * @return int index
     */
    public static int posledniMin(float[] a){
        float min = min(a);
        int index = 0;
        for (int i = a.length; i > 0; i--) {
            if (a[i] == min) {
                index = i;
            }
        }
        return index;
    }
    /**
     * pocet vsech vyskytu dane hodnoty v poli
     * @param float[]
     * @param float hodnota
     * @return int pocetVyskytu
     */
    public static int pocetVyskytu(float[] a, float n) {
        int pocet = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                pocet += 1;
            }
        }
        return pocet;
    }
    /**
     * pocet vyskytu dane hodnoty v poli na prvnich n prvcich 
     * @param float[]
     * @param float hodnota
     * @param int n
     * @return int pocetVyskytu
     */
    public static int pocetVyskytu(float[] a, int n, float d) {
        int pocet = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == d) {
                pocet += 1;
            }
        }
        return pocet;
    }
    /**
     * pocet sudych hodnot v poli 
     * @param int[]
     * @return int pocetSudychHodnot
     */
    public static int pocetSudych(float[] a) {
        int pocet = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                pocet += 1;
            }
        }
        return pocet;
    }
    /**
     * pocet lichych hodnot v poli
     * @param int[]
     * @return int pocetLichychHodnot
     */
    public static int pocetLichych(float[] a) {
        int pocet = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                pocet += 1;
            }
        }
        return pocet;
    }
    /**
     * index prvniho vyskytu dane hodnoty
     * @param float[]
     * @param float hodnota
     * @return int index
     */
    public static int prvniVyskyt(float[] a, float n) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                index = i;
                return index;
            }
        }
        return index;
    }
    /**
     * index posledniho vyskytu dane hodnoty
     * @param float[]
     * @param float hodnota
     * @return int index
     */
    public static int posledniVyskyt(float[] a, float n) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                index = i;
            }
        }
        return index;
    }
    /**
     * je pole vzestupne usporadane?
     * @param float[]
     * @return boolean
     */
    public static boolean vzestupne(float[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }
    /**
     * je pole sestupne usporadane?
     * @param float[] 
     * @return boolean
     */
    public static boolean sestupne(float[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[i - 1])
                return false;
        }
        return true;
    }
    /**
     * je pole stridava posloupnost cisel od 0? 
     * @param float[]
     * @return boolean
     */
    public static boolean stridavaPosloupnost(float [] a) {
        boolean stridave = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (a[i + 1] < 0) {
                    stridave = true;
                }
            } else {
                if (a[i + 1] > 0) {
                   stridave = true; 
                }
            }
        }
        return stridave;
    }
    /**
     * prevracene pole 
     * @param folat[]
     * @return float[]
     */
    public static float[] getReversed(float[] a) {
        float[] b = new float[a.length];
        for (int i = a.length; i > 0; i++) {
            for (int j = 0; j < a.length; j++) {
                b[j] = a[i];
            }
        }
        return b;
    }
    /**
     * prevraceni daneho pole
     * @param float[]
     */
    public static void reverse(float[] a) {
        a = getReversed(a);
    }
    /**
     * vygenerovani pole dane delky nahodnych hodnot v rozmezi
     * @param int delka pole
     * @param min
     * @param max
     * @return int[]
     */
    public static int[] nahodnePole(int n, int min, int max) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = radnomInRange(min, max);
        }
        return a;
    }
    /**
     * nahodne int v rozmezi
     * @param min
     * @param max
     * @return int nahodne cislo
     */
    private static int radnomInRange(int min, int max) {
        return (int)(Math.random() * (max - min) - min);
    }
}

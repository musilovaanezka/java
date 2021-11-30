/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv09.musilova;

/**
 *
 * @author Musilová
 */
public class MathTools {
    public static double aNaN(double a, int n) {
        double x = a;
        for (int i = 1; i < n; i++) {
            x *= a;
        }
        return x;  
    }
    public static double sin(double x, double eps){
        double sin = 0;
        int n = 1;
        int i = 2;
        double mezi = x; 
        while (mezi > eps){
            mezi = (aNaN((-1),i))*(aNaN(x, n) / fakt(n));
            sin += mezi;
            n += 2;
            i++;
        }
        return sin; 
    }
    public static int fakt(int a) {
        int x = 1;
        for (int i = 1; i <= a; i++){
            x = x * i; 
        }
        return x;
    }
    public static double ln(double x, double eps){
        double mezi = x;
        double ln = 0;
        int n = 1;
        while (mezi > eps){
            mezi = (aNaN((x - 1), n)) / (n*(aNaN((x + 1), n)));
            ln += 2*(mezi); 
            n += 2;
        }
        return ln;
    }
    public static double sqrt(double x, double eps){
        double sqrt = x / 2;
        double sqrt1 = 0;
        while (absh(sqrt - sqrt1) > eps) { 
            sqrt1 = sqrt;
            sqrt = (sqrt1 + (x / sqrt1)) / 2;
        }
        return sqrt;
    }
    public static double absh(double x) {
        if (x < 0) {
            x *= (-1);
        }
        return x;
    }
}

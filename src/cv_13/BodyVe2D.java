package cv_13;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class BodyVe2D {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = sc.nextInt();
        double[][] body = new double[n][2];
        System.out.println("x a y bodu:");
        for (int i = 0; i < n; i++) {
            body[i][0] = sc.nextDouble();
            body[i][1] = sc.nextDouble();
        }
        // procházení všech dvojic navzájem různých bodů
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double vzd = vzdalenost();
                
            }
        }
    }
    public static double vzdalenost(double[] a, double[] b) {
        double vzd  = Math.sqrt((a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]));
        Math.hypot();
        return vzd;
    }
}

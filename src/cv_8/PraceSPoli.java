package cv_8;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PraceSPoli {

    private static final Scanner sc = new Scanner(System.in);
    //musí být statický, aby nemusela být vytvořena instance pro jeho použití 
    private static final int KAPACITA = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //načítání hodnot do pole se známým počtem hodnot
        int n = sc.nextInt();
        float[] a = new float[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        
        //načítání hodnot do pole bez předem známého počtu hodnot 
        //do pole s určitou maximální délkou
        float[] b = new float[KAPACITA];
        float x;
        int i = 0;
        while ((x = sc.nextFloat()) > 0) {
            b[i] = x;
            i++;
        }
        //kolik hodnot bylo do pole načteno?
        int pocet = i;
        
        //metoda pro nečítání hodnot do pole
        private static float[] nactiPoleCisel() {
        }
        private static void nactiDataDoPole(float[] a, int n) {
        
        }
    }

}

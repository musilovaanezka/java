package cv10.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class EratosthenovoSito {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // vsechna cisla od 2 do k
        // k = rozsah hodnot
        // pole s max indexem = k (typ boolean) - inicializace - true
        // procházení pole od indexu 2
        // když se na dané pozici hodnota == true 
        //      cislo odpovidajici indexu = prvocislo
        //      násobky daného indexu nejsou prvocisla 
        //      prirazeni hodnoty false na prislusne pozice pole
        System.out.println("k = ");
        int k = sc.nextInt();
        boolean[] a = new boolean[k + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = true;
        }
        for (int i = 2; i <= a.length; i++) {
            if(a[i] == true) {
                System.out.println(a[i]);
                for (int j = i; j < a.length)
            }
        }
    }

}

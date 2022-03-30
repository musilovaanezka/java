package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PrevodSekund {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Počet sekund");
        int s = sc.nextInt();
    
        int hod = s / 3600;
        int min = (s - hod * 3600) / 60;
        int sek = (s - hod * 3600) % 60;
        
        System.out.format("čas: %d:%d:%d %n" , hod, min, sek);
    }

}

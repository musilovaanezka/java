package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class TestAritmetickePosloupnosti {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Pocet prvku:");
        int n = sc.nextInt();
        System.out.println("Prvky:");
        
        double prCislo = sc.nextDouble();
        double d = sc.nextDouble() - prCislo;
        boolean jeAritmeticka = false; 
        
        for(int i = 2; i < n; i++) {
            double cislo = sc.nextDouble(); 
            if ((prCislo + ((n - 1)*d)) == cislo) {
                jeAritmeticka = true;
            }
        }
        System.out.format("%n Posloupnost %s %n",(jeAritmeticka == true) ? "je aritmetická" : "není aritmetická");
    }

}

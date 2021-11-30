package cv09.musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class VypocetKvadratickeOdchylky {

    private final static int KAPACITA = 1000;
    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double x;
        int n = KAPACITA;
        double[] a = new double[n];
        double soucet = 0;
        
        System.out.println("je znam pocet hodnot? (a / n)");
        char volba = sc.next().charAt(0);
        
        switch (volba) {
            case 'n':
                
                // varianta bez znameho poctu mereni
                // nacitani hodnot
                // u fyzikalni veliciny neni predpoklad zaporne hodnoty
                System.out.println("Hodnoty:");
                
                while((n < a.length) && ((x = sc.nextDouble()) > 0)){
                    a[n] = x;
                    n++;
                    soucet += x;
                    if (n == a.length) {
                        System.out.println("Kapacita prekrocena");
                    }
                }
                break;
                
            case 'a':
                
                // varianta se zsdaným poctem mereni
                // nacitani hodnot
                System.out.println("Pocet mereni:");
                n = sc.nextInt();
                System.out.println("Hodnoty:");
                for(int k = 0; k < n; k++) {
                    x = sc.nextDouble();
                    a[k]= x;
                    soucet += x;
                }
                break;
                
            default: System.out.println("Nebyla zadana platna odpoved"); break;
        }
        
        
        // aritmeticky prumer
        double prumer = soucet / n;
        
        // nalezeni nejvetsi odchylky 
        double max = Math.abs(prumer - a[0]);
        double odch;
        
        // pro vypocet kvadraticke odchylky
        double sum = 0;
        
        for(int i = 0; i < n; i++) {
            odch = Math.abs(prumer - a[i]);
            if (odch > max){
                max = odch;
            } 
            sum += (MathTools.aNaN((a[i] - prumer), 2));
        }
        // vypocet kvadraticke odchylky
        System.out.println(n);
        double kvadrOdch = (1 / n) * sum;
        
        // vypisy
        System.out.format("Atitmeticky prumer = \t%1$,.2f%n", prumer);
        System.out.format("Maximalni odchylka = \t%1$,.2f%n", max);
        System.out.format("Kvadraticka odchylka = \t%1$,.2f%n", kvadrOdch);

    }

}

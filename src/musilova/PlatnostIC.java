package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class PlatnostIC {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("IČ k ověření:");
        int ic = sc.nextInt();
        
        String platne = "IČ je platné";
        String neplatne = "IČ je neplatné";
        
        //když je číslo delší než 8
        if (ic > 99_999_999) {
            System.out.println(neplatne);
        }
        //rozdělení zadaného čísla na cifry 
        //postupné násobení 1.-7. číslice čísly 8-2
        
        int prvni = ic / 10_000_000;
        int prvnin = prvni * 8;
        int help = prvni * 10_000_000;
        
        int druha = (ic - help) / 1_000_000;
        int druhyn = druha * 7;
        help = help + (druha * 1_000_000);
        
        int treti = (ic - help) / 100_000;
        int tretin = treti * 6;
        help = help + (treti * 100_000);
        
        int ctvrta = (ic - help) / 10_000;
        int ctvrtyn = ctvrta * 5;
        help = help + (ctvrta * 10_000);
        
        int pata = (ic - help) / 1_000;
        int patyn = pata * 4; 
        help = help + (pata * 1_000);
        
        int sesta = (ic - help) / 100;
        int sestyn = sesta * 3;
        help = help + (sesta * 100);
        
        int sedma = (ic - help) / 10;
        int sedmyn = sedma * 2;
        help = help + (sedma * 10);
        
        int osma = ic - help;
        
        //součet násobků
        int soucet = prvnin + druhyn + tretin + ctvrtyn + patyn + sestyn + sedmyn;
        
        //zbytek po dělení 11
        int zbytek = soucet % 11;
        
        //když je zbytek 0 
        //když je zbytek 1
        //když je zbytek jiný 
        
        if (zbytek == 0){
            if (osma == 1){
                System.out.println(platne);
            } else {
                System.out.println(neplatne);
            }
        } else if (zbytek == 1){
            if (osma == 0){
                System.out.println(platne);
            } else {
                System.out.println(neplatne);
            }
        } else {
            if (osma == zbytek){
                System.out.println(platne);
            } else {
                System.out.println(neplatne);
            }
        }
        
    }

}

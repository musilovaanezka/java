package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Prvocislo {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cislo;
        boolean opakovat = true;
       
        do {
            System.out.println("Cislo k testu:");
            cislo = sc.nextInt();
            
            //ukonceni cyklu po nalezeni prvniho delitele
            int delitel1 = 1; 
            do {
                delitel1++;
                if (cislo == delitel1) {
                   System.out.println("Cislo je prvocislo"); 
                } else {
                    if (cislo % delitel1 == 0)
                       System.out.format("%n Cislo neni prvocislo %n Cislo je delitelne napr. cislem %d %n" ,delitel1);
                }
         
            } while (cislo % delitel1 != 0);

            //testovani vsech potencialnich delitelu
            for (int delitel2 = 2; delitel2 < cislo; delitel2++) {
                if (cislo % delitel2 == 0){
                    System.out.format("%n Cislo neni prvocislo %n Cislo je delitelne cislem %d %n" ,delitel2);
                } else if (delitel2 == cislo) {
                    System.out.println("Cislo je prvocislo");
                } 
            }

                    
            //opakovani pro nove cislo
            System.out.println("Opakovat? a/n");
            String odpoved = sc.next();
            if (odpoved.equals("n")) {
                opakovat = false;
            }
            
        } while (opakovat == true);
    }
}

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
            System.out.println("Cislo k testu:");
            int cislo = sc.nextInt();
            
            int delitel1 = 2; 
            while(cislo % delitel1 != 0) {
                if (cislo % delitel1 == 0) {
                    System.out.println("Cislo neni prvocislo");
                } else if (delitel1 == cislo) {
                    System.out.println("Cislo je prvocislo");  
                } else { 
                    delitel1++;
                    System.out.println()
                }
                
            }
            
            
           // do { 
             //   if (cislo % delitel1 == 0) {
               //     System.out.format("%n Cislo neni prvocislo %n Cislo je delitelne napr. cislem %d %n" ,delitel1);
                //} else if (cislo == delitel1){
                 //   System.out.println("Cislo je prvocislo");
                //} else {
                  //  System.out.println((cislo % delitel1));
                    //delitel1++;  
              //  }           
            //} while (cislo % delitel1 != 0);
    }

}

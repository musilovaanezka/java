package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class Kalkulacka {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("retezec aritmetickych operaci:");
        double v = sc.nextDouble();
        char op;
        
        do {
            op = sc.next().charAt(0);
            
        } while(op != '=');
        
        while (oper != "=") {
            char op = sc.next().charAt(0);
            double x = sc.nextDouble();
            
            switch (op) {
                case '+': v += x; break;
                case '-': v -= x; break; 
                case '*': v *= x; break;
                case '/': v /= x; break;   
            }
            oper = sc.next();
        }
        System.out.println(v);




    }

}

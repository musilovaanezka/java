package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class KalkulatorSPrioritouOperaci {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Operace ukončeny =");
        double v = sc.nextDouble();
        double m;
        char op;
        char op2;
        
        do {
            op = sc.next().charAt(0);
            
            if (op == '+' || op == '-') {
                m = sc.nextDouble();
                op2 = sc.next().charAt(0);
                if (op2 == '*' || op2 == '/') {
                    switch (op2) {
                        case '*': m = m * sc.nextDouble(); break;
                        case '/': m = m / sc.nextDouble(); break;   
                    }
                }
                switch (op) {
                    case '+': v = v + m; break;
                    case '-': v = v - m; break;
                }
            }
        } while(op != '=');
        System.out.println("vysledek = " + v);
        
    }

}

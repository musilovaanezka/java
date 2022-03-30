package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class TestBod {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bod b1;
        //volání metody konstruktoru 
        //tvorba nové instance 
        //uložení reference do konkrétní proměnné 
        b1 = new Bod(4, 9);
        
        Bod b2 = new Bod(4.5, -8);
    }

}

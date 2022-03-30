package musilova;
 
/**
 *
 * @author Musilová
 */
import java.util.Scanner;

public class NMocnina {
    
    private static Scanner sc = new Scanner(System.in); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a = sc.nextDouble();
        int n = sc.nextInt();
        
        int i = 0;
        double moc = 1;
        
        //pomocí příkazu while
        while (i < n) {
            moc *= a;
            i++;
            
        }
    }

}

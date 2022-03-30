package cv_06_2;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class VycetUkazka {

    private static final Scanner sc = new Scanner(System.in);

    public static enum Dny {
        PONDELI, UTERY, STREDA, CTVRTEK, PATEK, SOBOTA, NEDELE;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Dny.values()[2]);
    }

}

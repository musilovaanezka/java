package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class MatrixTransformationTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int volba = 1;
        System.out.println("Zadejte svou prvni matici:");
        int[][]a = nacteniMatice();
        while (volba > 0) {
            menu();
            volba = volba();
            switch (volba) {
                case 1: 
                    a = nacteniMatice();
                    break;
                case 2:
                    vypisMatice(a);
                    break;
                case 3:
                    a = MatrixTransformationTools.transpozice(a);
                    vypisMatice(a);
                    break;
                case 4:
                    MatrixTransformationTools.prevraceniVertikalne(a);
                    vypisMatice(a);
                    break;
                case 5:
                    MatrixTransformationTools.prevraceniHorizontalne(a);
                    vypisMatice(a);
                    break;
                case 6:
                    a = MatrixTransformationTools.rotaceO90PoSmeru(a);
                    vypisMatice(a);
                    break;
                case 7:
                    a = MatrixTransformationTools.rotaceO90ProtiSmeru(a);
                    vypisMatice(a);
                    break;
            }
        }
    }
    private static int volba() {
        int volba = sc.nextInt();
        while (volba < 0 || volba > 7) {
            System.out.println("chybny vstup, zkuste zadat znovu");
            volba = sc.nextInt();
        }
        return volba;
    }
    
    private static void menu() {
        System.out.println("1 - nacteni matice");
        System.out.println("2 - vypis aktualniho stavu matice");
        System.out.println("3 - transpozice matice");
        System.out.println("4 - prevraceni dle vertikalni osy");
        System.out.println("5 - prevraceni dle horizontalni osy");
        System.out.println("6 - rotace o pravy uhel v kladnem smeru");
        System.out.println("7 - rozace o pravy uhel v zapornem smeru");
        System.out.println("0 - konec programu");
    }
    
    private static int[][] nacteniMatice() {
        System.out.println("radky a sloupce:");
        int radky = sc.nextInt();
        int sloupce = sc.nextInt();
        if (radky < 0 || sloupce < 0) {
            System.out.println("Byly zadany zaporne rozmery matice, byly prevedeny na kladne");
            radky = Math.abs(radky);
            sloupce = Math.abs(sloupce);
        }
        int[][] matice = new int[radky][sloupce];
        double hodnota;
        System.out.println("prvky:");
        for (int i = 0; i < radky; i++) {
            for (int j = 0; j < sloupce; j++) {
                hodnota = sc.nextDouble();
                matice[i][j] = (int) hodnota;
            }
        }
        return matice;
    }
    
    private static void vypisMatice(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.geom;

import java.util.Scanner;
/**
 *
 * @author Musilová
 */
public class TrojuhelnikTest {
    
    private static final Scanner sc = new Scanner(System.in); 
    
    public static void main(String[] args) {
        double a = 1;
        double b, c;
        System.out.println("zadavejte delky stran do zadani nuly, nebo zaporneho cisla");
        while ((a = sc.nextDouble()) > 0) {
            b = sc.nextDouble();
            c = sc.nextDouble();
            
            // vypis veskerych vlastnosti trojuhelnika
            Trojuhelnik t = new Trojuhelnik(1,2,3);
            System.out.println(t.getA());
            System.out.println(t.obvod());
            System.out.println(t.obsah());
            System.out.println(t.jeRovnostranny() ? "Je rovnostranny" : "Neni rovnostranny");
            System.out.println(t.jeRovnoramenny() ? "Je rovnoramenny" : "Neni rovnoramenny");
            System.out.println(t.jePravouhly() ? "Je pravouhly" : "Neni pravouhly");
            System.out.println(t.jeTupouhly() ? "Je tupouhly" : "Neni tupouhly");
            System.out.println(t.jeOstrouhly() ? "Je ostrouhly" : "Neni ostrouhly");
            System.out.println("");
            System.out.println("zadejte dalsi trojuhelnik");
        }
    }
}

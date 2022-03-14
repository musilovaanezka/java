/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.cisla;

/**
 *
 * @author Musilová
 */
public class KomplexniCisla {
    private KomplexniCisla() {}
    
    public static KomplexniCislo soucet(KomplexniCislo a, KomplexniCislo b) {
        double x1 = a.getrC();
        double y1 = a.getkC();
        double x2 = b.getrC();
        double y2 = b.getkC();
        return new KomplexniCislo((x1 + x2),(y1 + y2));
    }
    public static KomplexniCislo rozdil(KomplexniCislo a, KomplexniCislo b) {
        double x1 = a.getrC();
        double y1 = a.getkC();
        double x2 = b.getrC();
        double y2 = b.getkC();
        return new KomplexniCislo((x1 - x2),(y1 - y2));
    }
    public static KomplexniCislo soucin(KomplexniCislo a, KomplexniCislo b) {
        double x1 = a.getrC();
        double y1 = a.getkC();
        double x2 = b.getrC();
        double y2 = b.getkC();
        return new KomplexniCislo((x1* x2 - y1 * y2),(x1* y2 + y1 * x2));
    }
    public static KomplexniCislo podil(KomplexniCislo a, KomplexniCislo b) {
        double x1 = a.getrC();
        double y1 = a.getkC();
        double x2 = b.getrC();
        double y2 = b.getkC();
        double x = (x1*x2 + y1*y2) / (x2*x2 + y2*y2);
        double y = (y1*x2 - x1*y2) / (x2*x2 + y2*y2);
        return new KomplexniCislo(x,y);
    }
}

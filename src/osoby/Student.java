/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osoby;

/**
 *
 * @author Musilová
 */
public class Student extends Osoba {
    private final String stc;

    public Student(String stc, String jmeno, String prijmeni, int rc) {
        super(jmeno, prijmeni, rc);
        this.stc = stc;
    }
    public Student(Osoba o, String c) {
        super(o.getJmeno(), o.getPrijmeni(), o.getRc());
        this.stc = c;
    } 

    public String getStc() {
        return stc;
    }
    
}

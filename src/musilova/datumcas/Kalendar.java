// mesic, rok
// getInstance
// getDatumAsStr
// getMesicniKalendar
// dalsiDen
// predchoziDen
// dalsiMesic
// predchoziMesic
// dalsiRok
// predchoziRok
package musilova.datumcas;

/**
 *
 * @author Musilová
 */
public class Kalendar {
    private int den;
    private int mesic; 
    private int rok;
    private static final int[] pdvm = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] pdvmP = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    public static enum DenVTydnu {
        PONDELI, UTERY, STREDA, CTVRTEK, PATEK, SOBOTA, NEDELE
    }
    public static enum Mesic {
        LEDEN, UNOR, BREZEN, DUBEN, KVETEN, CERVEN, CERVENEC, SRPEN, ZARI, RIJEN, LISTOPAD, PROSINEC
    }
    
    private Kalendar(int d, int m, int r) {
        den = d;
        mesic = m;
        rok = r;
    }
    private Kalendar(Kalendar cal) {
        den = cal.getDen();
        mesic = cal.getMesic();
        rok = cal.getRok();
    }
    
    public static Kalendar getInstance(int d, int m, int r) {
        if (d > 31 || d < 1 || m > 12 || m < 1) {
            throw new IllegalArgumentException("jeden nebo vice parametru byly zadany neplatne");
        }
        // kontrola dne v mesici
        if (m == 2 && d > 29) throw new IllegalArgumentException("je unor");
        if (m < 8 && m % 2 == 0 && m > 30) throw new IllegalArgumentException("tento mesic nema 31 dni");
        if (m > 8 && m % 2 != 0 && m > 30) throw new IllegalArgumentException("tento mesic nema 31 dni");
        
        return new Kalendar(d,m,r);
    }
    public static Kalendar getInstance(Kalendar cal) {
        return new Kalendar(cal);
    }

    public int getDen() {
        return den;
    }

    public int getMesic() {
        return mesic;
    }

    public int getRok() {
        return rok;
    }
    public String getDatumAsStr(){
        return den + "." + mesic + "." + rok;
    }
    
    public static boolean prestupnyRok(int r) {
        return ((r % 100) != 0 || (r % 400) == 0) && (r % 4 == 0);
    }
    private int denVTydnu(int d, int m, int r) {
        if (m < 3) {
                m += 12;
                r -= 1;
            }
        return (d + ((26 * (m + 1)) / 10) + r + (r / 4) + (6 * (r / 100) + (r / 400))) % 7;
    }
    private static DenVTydnu prevodDneVTydnu(int d) {
        switch (d) {
            case 2: return DenVTydnu.PONDELI; 
            case 3: return DenVTydnu.UTERY;
            case 4: return DenVTydnu.STREDA;
            case 5: return DenVTydnu.CTVRTEK;
            case 6: return DenVTydnu.PATEK;
            case 0: return DenVTydnu.SOBOTA;
            case 1: return DenVTydnu.NEDELE;
        }
        return null;
    }
    private static Mesic prevodMesice(int m) {
        switch (m) {
            case 1: return Mesic.LEDEN;
            case 2: return Mesic.UNOR;
            case 3: return Mesic.BREZEN;
            case 4: return Mesic.DUBEN;
            case 5: return Mesic.KVETEN;
            case 6: return Mesic.CERVEN;
            case 7: return Mesic.CERVENEC;
            case 8: return Mesic.SRPEN;
            case 9: return Mesic.ZARI;
            case 10: return Mesic.RIJEN;
            case 11: return Mesic.LISTOPAD;
            case 12: return Mesic.PROSINEC;
        }
        return null;
    }
    public String getMesicniKalendar() {
        int pdvmm = (prestupnyRok(rok) ? pdvmP[mesic-1] : pdvm[mesic-1]);
        Mesic ms = prevodMesice(mesic);
        
        
        StringBuilder cal = new StringBuilder();
        String head = "PO  UT  ST  CT  PA  SO  NE " + ms.toString() + " " + rok;
        
        DenVTydnu dvt = prevodDneVTydnu(denVTydnu(den,mesic,rok));
        DenVTydnu zdvt = prevodDneVTydnu(denVTydnu(1,mesic,rok));
        int zcdvt = DenVTydnu.valueOf(zdvt.toString()).ordinal() + 1;
        
        cal.append(dvt);
        cal.append("\n");
        cal.append(head);
        cal.append("\n");
        
        for (int i = 0; i < zcdvt; i++) {
            cal.append("  ");
        }
        int k = 1;
        for (int j = zcdvt; j <= 7; j++) {
            cal.append(k);
            cal.append("   ");
            k++;
        }
        cal.append("\n");
        while (k < pdvmm) {
            for (int l = 0; l < 7; l++) {
                if (k > pdvmm) {
                    break;
                }
                if (k == den) {
                    cal.append("*");
                    cal.append(k);
                    cal.append("*");
                } else {
                    cal.append(k);
                    if (k < 10) cal.append(" ");
                    cal.append("  ");
                }
                k++;
            } 
            cal.append("\n");
        }
        return cal.toString();
    }
    public String dalsiDen(){
        this.den++;
        return getMesicniKalendar();
    }
    public String predchoziDen() {
        this.den--;
        return getMesicniKalendar();
    }
    public String dalsiMesic() {
        this.mesic++;
        return getMesicniKalendar();
    }
    public String predchoziMesic() {
        this.mesic--;
        return getMesicniKalendar();
    }
    public String dalsiRok() {
        this.rok++;
        return getMesicniKalendar();
    }
    public String predchoziRok() {
        this.rok--;
        return getMesicniKalendar();
    }
    public static void main(String[] args) {
        Kalendar cal = Kalendar.getInstance(22, 3, 2022);
        System.out.println(cal.getMesicniKalendar());
    }
}

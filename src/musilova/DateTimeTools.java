/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova;

/**
 *
 * @author Musilová
 */
public class DateTimeTools {

    /**
     * test, zda je dany rok prestupny
     * @param int rok
     * @return boolean 
     */
    public static boolean prestupnyRok(int rok) {
        return rok % 4 == 0;
    }

    /**
     * test, zda je datum platne
     * @param int rok
     * @param int mesic
     * @param int den
     * @return boolean
     */
    public static boolean platnostData(int rok, int mesic, int den) {
        return (den < pocetDniMesice(rok, mesic) && den > 1 && mesic <= 12 && mesic > 1);

    }

    /**
     * test, zda je datum platné
     * @param int hodiny
     * @param int minuty
     * @param int sekundy
     * @return boolean
     */
    public static boolean platnostCasu(int h, int m, int s) {
        return (h >= 1 && h < 24 && m >= 1 && m < 60 && s >= 1 && s < 60);
    }
    
    /**
     * cislo dne v tydnu, kdyz sobota = 0 
     * @param int rok
     * @param int mesic
     * @param int den
     * @return int   
     */
    public static int cisloDneVTydnu(int rok, int mesic, int den) {
        int cislo = -1;
        if (platnostData(rok, mesic, den)) {
            if (mesic < 3) {
                mesic += 12;
                rok -= 1;
            }
            cislo = (den + ((26 * (mesic + 1)) / 10) + rok + (rok / 4) + (6 * (rok / 100) + (rok / 400))) % 7;
        }
        return cislo;
    }
    
    /**
     * nazev dne v tydnu  
     * @param int rok
     * @param int mesic
     * @param int den
     * @return String
     */
    public static String denVTydnu(int rok, int mesic, int den) {
        int cislo = cisloDneVTydnu(rok, mesic, den);
        String d = "den";
        switch (cislo) {
            case 0: d = "sobota"; break; 
            case 1: d = "nedele"; break;
            case 2: d = "pondeli"; break;
            case 3: d = "utery"; break;
            case 4: d = "streda"; break;
            case 5: d = "ctvrtek"; break;
            case 6: d = "patek"; break;
        }
        return d;
    } 

    /**
     * pocet dni v danem mesici s ohledem na prestupne roky
     * @param int rok
     * @param int mesic
     * @return int
     */
    public static int pocetDniMesice(int rok, int mesic) {
        int dny = 0;
        switch (mesic) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                dny = 31;
            }
            case 4, 6, 9, 11 -> {
                dny = 30;
            }
            case 2 -> {
                if (prestupnyRok(rok)) {
                    dny = 29;
                } else {
                    dny = 28;
                }
            }
            default ->
                System.out.println("Neplatný měsíc");
        }
        return dny;
    }

    /** 
     * prevod casu na jednu hodnotu v dane jednotce
     * @param String jednotka
     * @param int hodiny
     * @param int minuty
     * @param int sekundy
     * @return int hodnota 
     */
    public static float casNaHodnotu(String jednotka, int h, int m, int s) {
        float v = 0;
        if (platnostCasu(h, m, s)) {
            switch (jednotka) {
                case "h":
                    v = h + (m / 60) + (s / 3600);
                    break;
                case "m":
                    v = (h * 60) + m + (s / 60);
                    break;
                case "s":
                    v = (h * 3600) + (m * 60) + s;
                    break;
                case "d":
                    v = (s / 86400) + (m / 1440) + (h / 24);
                    break;
            }
        }
        return v;
    }

    /**
     * prevod jedne hodnoty na sekundy
     * @param String jednotka
     * @param int hodnota 
     * @return int sekundy
     */
    public static int prevodNaSekundy(String jednotka, float v) {
        int s = 0;
        switch (jednotka) {
            case "d":
                s = (int) (v * 86400);
                break;
            case "h":
                s = (int) (v * 3600);
                break;
            case "m":
                s = (int) (v * 60);
                break;
            case "s":
                v = s;
                break;
        }
        return s;
    }

    /**
     * prevod jedne hodnoty na pole cas, kde cas[0] = int den a cas[3] = int sekundy 
     * @param String jednotka
     * @param int hodnota 
     * @return int[] 
     */
    public static int[] hodnotaNaCas(String jednotka, float v) {
        int s = prevodNaSekundy(jednotka, v);
        int[] cas = new int[4];
        cas[0] = s / 86400;
        cas[1] = (int) (v - cas[0] * 24);
        s = s - cas[0] * 24 - cas[1];
        cas[2] = s / 60;
        cas[3] = s - (cas[2] * 60);
        return cas;
    }
}

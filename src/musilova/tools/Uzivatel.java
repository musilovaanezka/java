/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Musilová
 */
public class Uzivatel {

    private static int IDs = 1;

    private final int vek;
    private double vaha;
    private int vyska;
    private final Pohlavi pohlavi;
    private double BMR;
    private File userFile;
    private int id;

    /**
     * vycet moznych pohlavi uzivatele
     */
    public static enum Pohlavi {
        ZENA, MUZ, JINE;
    }

    private Uzivatel(int vek, double vaha, int vyska, Pohlavi pohlavi, File adr) throws IOException, InterruptedException {
        this.vek = vek;
        this.vaha = vaha;
        this.vyska = vyska;
        this.pohlavi = pohlavi;
        this.BMR = vypocetBMR();
        this.id = pridelID(adr);
        this.userFile = new File(adr.toString() + "/user_" + this.id + ".txt");
        Files.createFile(userFile.toPath());
        Zahlavi();
    }
    
    private int pridelID(File adr) {
        File[] files = adr.listFiles();
        int max = 0;
        for (File f : files) {
            String[] strparts = f.getPath().split("_");
            String s = strparts[strparts.length - 1];
            int i = (Integer.parseInt("" + s.charAt(0)));
            if(i > max) max = i;
        }
        return max + 1;
    }

    // vypocet bazalni metabolicke hodnoty kcal
    private double vypocetBMR() {
        switch (pohlavi) {
            case MUZ:
                return 13.397 * vaha + 4.799 * vyska - 5.677 * vek + 88.362;
            case ZENA:
                return 9.247 * vaha + 3.098 * vyska - 4.330 * vek + 447.593;
            default:
                double bmrm = 13.397 * vaha + 4.799 * vyska - 5.677 * vek + 88.362;
                double bmrz = 9.247 * vaha + 3.098 * vyska - 4.330 * vek + 447.593;
                return (bmrm + bmrz) / 2;
        }
    }

    /**
     * tvorba instance uzivatele
     *
     * @param vek int
     * @param vaha double
     * @param vyska int
     * @param pohlavi Pohlavi
     * @throws IllegalArgumentException v pripade zadani neplatnych dat
     */
    public static Uzivatel getInstance(int vek, double vaha, int vyska, Pohlavi pohlavi) throws IOException, InterruptedException {
        File adr = new File("./uzivateleSport");
        if (!adr.isDirectory()) {
            Files.createDirectory(adr.toPath());
        }
        return getInstance(vek, vaha, vyska, pohlavi, adr);
    }

    public static Uzivatel getInstance(int vek, double vaha, int vyska, Pohlavi pohlavi, File adr) throws IOException, InterruptedException {
        if (vek < 0 || vek > 130) {
            throw new IllegalArgumentException("vek neodpovida" + vek);
        }
        if (vaha <= 0 || vaha > 500) {
            throw new IllegalArgumentException("vaha neodpovida" + vaha);
        }
        if (vyska < 30 || vyska > 240) {
            throw new IllegalArgumentException("vyska neodpovida" + vyska);
        }
        if (!adr.isDirectory()) {
            throw new IllegalArgumentException("zadany adresar neexistuje" + adr.toString());
        }
        return new Uzivatel(vek, vaha, vyska, pohlavi, adr);
    }

    /**
     * zmena vahy uzivatele
     *
     * @param vaha double
     * @throws IllegalArgumentException v pripade, ze vaha neni zadana platne
     */
    public void setVaha(double vaha) {
        if (vaha <= 0 || vaha > 500) {
            throw new IllegalArgumentException("vaha neodpovida" + vaha);
        }
        this.vaha = vaha;
        this.BMR = vypocetBMR();
    }

    /**
     * zmena vysky uzivatele
     *
     * @param vyska int
     * @throws IllegalArgumentException v pripade neplatne zadane vysky, nebo
     * kdyz se vyska uzivatele zmensila
     */
    public void setVyska(int vyska) {
        if (vyska < 30 || vyska > 240) {
            throw new IllegalArgumentException("vyska neodpovida" + vyska);
        }
        if (vyska < this.vyska) {
            throw new IllegalArgumentException("vase vyska se zmensila?" + vyska);
        }
        this.vyska = vyska;
        this.BMR = vypocetBMR();
    }

    /**
     * getter pro vek
     *
     * @return vek int
     */
    public int getVek() {
        return vek;
    }

    /**
     * getter pro vahu
     *
     * @return vaha double
     */
    public double getVaha() {
        return vaha;
    }

    /**
     * getter pro vysku
     *
     * @return vyska int
     */
    public int getVyska() {
        return vyska;
    }

    /**
     * getter pro pohlavi
     *
     * @return pohlavi Pohlavi
     */
    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    /**
     * getter pro bazalni metabolickou sportebu calorii
     *
     * @return double BMR
     */
    public double getBMR() {
        return this.BMR;
    }

    /**
     * getter pro soubor uzivatele
     *
     * @return File cesta k souboru uzivatele
     */
    public File getUserFile() {
        return this.userFile.getAbsoluteFile();
    }

    /**
     * prepsana metoda toString() urcena pro zapis do souboru
     *
     * @return String vek; vaha; vyska; pohlavi
     */
    @Override
    public String toString() {
        return "" + vek + ";" + vaha + ";" + vyska + ";" + pohlavi;
    }

    /**
     * zpis zahlavi do uzivatelskeho souboru
     */
    private void Zahlavi() throws IOException {
        try ( BufferedWriter bw = Files.newBufferedWriter(userFile.toPath(), StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
            bw.append(toString());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        Uzivatel honza = Uzivatel.getInstance(23, 60, 189, Uzivatel.Pohlavi.MUZ);
//        System.out.println(honza.id);
//        Uzivatel tonik = Uzivatel.getInstance(23, 60, 189, Uzivatel.Pohlavi.MUZ);
//        System.out.println(tonik.id);
        String str = "hajojdlskdf_wanqwie_4.txt";
        String[] strar = str.split("_");
        String s = strar[strar.length - 1];
        System.out.println(Integer.parseInt("" + s.charAt(0)));
    }
}

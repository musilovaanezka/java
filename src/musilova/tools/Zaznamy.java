/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musilova.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import musilova.tools.aktivity.Casove;
import musilova.tools.aktivity.Vzdalenostni;
import musilova.tools.datumACas.Datum;

/**
 *
 * @author Musilová
 */
public class Zaznamy {

    // zapis do souboru
    private static void zapisAktivity(Uzivatel user, Aktivita aktivita, Datum datum) throws IOException {

        try ( BufferedWriter bw = Files.newBufferedWriter(user.getUserFile().toPath(), StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
            bw.newLine();
            StringBuilder sb = new StringBuilder();
            sb.append(datum.toString());
            sb.append(aktivita.toString());
            bw.write(String.format("%s %n", sb.toString()));
        }
    }

    // cteni ze souboru
    public static List<String> cteniVsech(Uzivatel user) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(user.getUserFile()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
    
    public static List<String> cteniZaznamuDleData(Uzivatel user) throws IOException {
        Datum date = new Datum();
        return cteniZaznamuDleData(user, date);
    }
    public static List<String> cteniZaznamuDleData(Uzivatel user, int d, int m, int r) throws IOException {
        Datum date = Datum.getInstance(d, m, r);
        return cteniZaznamuDleData(user, date);
    }

    private static List<String> cteniZaznamuDleData(Uzivatel user, Datum date) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(user.getUserFile()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(date.toString())) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    public static List<String> cteniZaznamuDleAktivity(Uzivatel user, String activityName) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();
        activityName.toLowerCase();
        try (BufferedReader br = new BufferedReader(new FileReader(user.getUserFile()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                if (line.contains(activityName)) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }
    public static List<String> cteniZaznamuOdDoData(Uzivatel user, int sd, int sm, int sr, int ed, int em, int er) throws IOException {
        Datum startDate = Datum.getInstance(sd, sm, sr);
        Datum endDate = Datum.getInstance(ed, em, er);
        return cteniZaznamuOdDoData(user, startDate, endDate);
    }
    private static List<String> cteniZaznamuOdDoData(Uzivatel user, Datum startDate, Datum endDate) throws FileNotFoundException, IOException {
        LocalDate start = Datum.prevod(startDate);
        LocalDate end = Datum.prevod(endDate);
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(user.getUserFile()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String dateStr = parts[0];
                String[] dateParts = dateStr.split("\\.");
                Datum datum = Datum.getInstance(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                LocalDate date = Datum.prevod(datum);
                if((date.isBefore(end) && date.isAfter(start)) || date.isEqual(start) || date.isEqual(end)) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }
    public static List<String> cteniZaznamuOdDoDleAktivity(Uzivatel user, int sd, int sm, int sr, int ed, int em, int er, String activityName) throws IOException {
        Datum startDate = Datum.getInstance(sd, sm, sr);
        Datum endDate = Datum.getInstance(ed, em, er);
        return cteniZaznamuOdDoDleAktivity(user, startDate, endDate, activityName);
    }
    public static List<String> cteniZaznamuOdDoDleAktivity(Uzivatel user, Datum startDate, Datum endDate, String activityName) throws IOException {
        List<String> lines = cteniZaznamuOdDoData(user, startDate, endDate);
        activityName = activityName.toLowerCase();
        for (String s : lines) {
            s = s.toLowerCase();
            if(!s.contains(activityName)) {
                lines.remove(s);
            }
        }
        return lines;
    }
    public static Uzivatel tvorbaUzivatele(int vek, double vaha, int vyska, int pohl) throws IOException, InterruptedException {
        Uzivatel user = null;
        try {
            Uzivatel.Pohlavi pohlavi = null;
            switch (pohl) {
                case 1 -> pohlavi = Uzivatel.Pohlavi.ZENA;
                case 2 -> pohlavi = Uzivatel.Pohlavi.MUZ;
                case 3 -> pohlavi = Uzivatel.Pohlavi.JINE;
                default -> throw new IllegalArgumentException("");
            }
            user = (Uzivatel.getInstance(vek, vaha, vyska, pohlavi));
            
        } catch (IllegalArgumentException ex) {
            return null;
        }
        return user;
    }
    public static Uzivatel nacteniUzivatele(String cesta) {
        File file = new File(cesta);
        try {
            return Uzivatel.getInstance(file);
        } catch (Exception ex) {
            return null;
        }
    }
    public static void zapisCasAktivity(double minuty, int avHb, Uzivatel user, int den, int mesic, int rok) throws IOException {
        Datum date = Datum.getInstance(den, mesic, rok);
        zapisCasAktivity(minuty, avHb, user, date);
    }
    public static void zapisCasAktivity(double minuty, int avHb, Uzivatel user) throws IOException {
        Datum date = new Datum();
        zapisCasAktivity(minuty, avHb, user, date);
    }
    private static void zapisCasAktivity(double minuty, int avHb, Uzivatel user, Datum date) throws IOException{
        Aktivita casova = Casove.getInstance(minuty, avHb, user);
        zapisAktivity(user, casova, date);
    }
    
    public static void zapisVzdAktivity(double minuty, double vzd, int avHb, Uzivatel user, int den, int mesic, int rok) throws IOException {
        Datum date = Datum.getInstance(den, mesic, rok);
        zapisVzdAktivity(minuty, vzd, avHb, user, date);
    }
    public static void zapisVzdAktivity(double minuty, double vzd, int avHb, Uzivatel user) throws IOException {
        Datum date = new Datum();
        zapisVzdAktivity(minuty, vzd, avHb, user, date);
    }
    private static void zapisVzdAktivity(double minuty, double vzd, int avHb, Uzivatel user, Datum date) throws IOException {
        Aktivita vzdal = Vzdalenostni.getInstance(minuty, vzd, avHb, user);
        zapisAktivity(user, vzdal, date);
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Uzivatel karel = Uzivatel.getInstance(23, 60, 189, Uzivatel.Pohlavi.MUZ);
        Casove aktivita = Casove.getInstance(23, 130, karel);
        Datum dnes = new Datum();
        zapisAktivity(karel, aktivita, dnes);
        //System.out.println(cteniZaznamuOdDoData(karel, Datum.getInstance(13, 9, 2021), Datum.getInstance(30, 5, 2022)));
        //System.out.println(cteniZaznamuDleAktivity(karel, "vzdalenostni"));
        System.out.println(cteniZaznamuOdDoDleAktivity(karel, Datum.getInstance(13, 9, 2021), Datum.getInstance(30, 5, 2022), "casove"));
        System.out.println(karel.getUserFile().getName());
    }
}

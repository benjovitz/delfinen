package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Filehandler {

    private PrintStream out;
    private BufferedReader br;
    private String line = "";

    public void readFile() {
        {
            try {
                br = new BufferedReader(new FileReader("memberFile.csv"));

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    System.out.printf("%-35s", "Navn: " + values[0]);
                    System.out.printf("%-20s", "Fødselsår : " + values[1]);
                    System.out.printf("%-20s %n %n", "Medlemsnummer: " + values[4]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveRecords(ArrayList<Svømmer> svømmers) throws FileNotFoundException {
        out = new PrintStream(new File("memberFile.csv"));
        String csvString;
        for (Svømmer svømmer : svømmers) {
            String navn = svømmer.getName();
            int år = svømmer.getÅr();
            int måned = svømmer.getMåned();
            int dag = svømmer.getDag();
            int medlemsnummer = svømmer.getMedlemsnummer();
            boolean erAktiv = svømmer.getErAktiv();
            boolean harBetalt = svømmer.getHarbetalt();
            if (svømmer instanceof Konkurrence) {
                Disciplin disciplin = ((Konkurrence) svømmer).getDisciplin();
                RekordTid rekordTid = ((Konkurrence) svømmer).getRekordTid();
                double tid = rekordTid.getTime();
                String dato = rekordTid.getDato();
                String træner = ((Konkurrence) svømmer).getTræner();
                csvString = navn + ";" + år + ";" + måned + ";" + dag + ";" + medlemsnummer+";" + erAktiv + ";"+harBetalt+";" + disciplin+";"+tid+";"+dato+";"+træner;
                out.println(csvString);
            }else {
                csvString = navn + ";" + år + ";" + måned + ";" + dag + ";" + medlemsnummer + ";" + erAktiv+";"+harBetalt;
                out.println(csvString);
            }
        }
    }

    public ArrayList<Svømmer> loadRecords() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("memberFile.csv"));
        ArrayList<Svømmer> svømmers = new ArrayList<>();
        while (fileScanner.hasNext()) {
            String fileLine = fileScanner.nextLine();
            String[] value = fileLine.split(";");
            Scanner input = new Scanner(fileLine).useDelimiter(";").useLocale(Locale.ENGLISH);
            String navn = input.next();
            int år = input.nextInt();
            int måned = input.nextInt();
            int dag = input.nextInt();
            int medlemNR = input.nextInt();
            boolean erAktiv=input.nextBoolean();
            boolean harBetalt=input.nextBoolean();
            if (value.length > 5) {
                Disciplin disciplin = Disciplin.valueOf(input.next());
                double tid = input.nextDouble();
                String dato = input.next();
                RekordTid rekordTid = new RekordTid(tid, dato, medlemNR);
                String træner = input.next();
                Konkurrence konkurrence = new Konkurrence(navn, år, måned, dag, medlemNR, erAktiv,harBetalt, disciplin, rekordTid);
                konkurrence.setTræner(træner);
                svømmers.add(konkurrence);
            } else {
                Motionist motionist = new Motionist(navn, år, måned, dag, medlemNR, erAktiv,harBetalt);
                svømmers.add(motionist);
            }
        }
        return svømmers;
    }

    public void saveKonkurrencetider(ArrayList<RekordTid> konkurrencetider) throws FileNotFoundException {
        out = new PrintStream(new File("konkurrencetider.csv"));
        String csvString;
        for (RekordTid rekordTid : konkurrencetider) {
            double tid = rekordTid.getTime();
            int placering = rekordTid.getPlacering();
            String stævne = rekordTid.getStævne();
            int medlemsnummer = rekordTid.getMedlemsnummer();
            Disciplin disciplin = rekordTid.getDisciplin();
            csvString = tid + ";" + placering + ";" + stævne + ";" + medlemsnummer+";"+disciplin;
            out.println(csvString);
        }
    }

    public ArrayList<RekordTid> loadKonkurrenctider() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("konkurrencetider.csv"));
        ArrayList<RekordTid> konkurrencetider = new ArrayList<>();
        while (fileScanner.hasNext()) {
            String fileLine = fileScanner.nextLine();
            Scanner input = new Scanner(fileLine).useDelimiter(";").useLocale(Locale.ENGLISH);
            double tid = input.nextDouble();
            int placering = input.nextInt();
            String stævne = input.next();
            int medlemsnummer = input.nextInt();
            Disciplin disciplin = Disciplin.valueOf(input.next());
            RekordTid rekordTid = new RekordTid(tid, placering, stævne, medlemsnummer,disciplin);
            konkurrencetider.add(rekordTid);
        }
        return konkurrencetider;
    }


}

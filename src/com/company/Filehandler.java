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
                    System.out.println("name: " + values[0] + " age: " + values[1] + " membernr: " + values[2]);

                    System.out.println(line);
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
            if (svømmer instanceof Konkurrence) {
                Disciplin disciplin = ((Konkurrence) svømmer).getDisciplin();
                RekordTid rekordTid = ((Konkurrence) svømmer).getRekordTid();
                double tid = rekordTid.getTime();
                String dato = rekordTid.getDato();
                String træner = ((Konkurrence) svømmer).getTræner();
                csvString = navn + ";" + år + ";" + måned + ";" + dag + ";" + medlemsnummer + ";" + erAktiv + ";" + disciplin + ";" + tid + ";" + dato + ";" + træner;
                out.println(csvString);
            } else {
                csvString = navn + ";" + år + ";" + måned + ";" + dag + ";" + medlemsnummer + ";" + erAktiv;
                out.println(csvString);

            }
        }
        System.out.println("finished writing file");
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
            boolean erAktiv;
            if (fileLine.contains("true")) {
                erAktiv = true;
            } else {
                erAktiv = false;
            }
            if (value.length > 6) {
                //scanner true eller false linjen så den ikke stopper med at indlæse eller indlæser forkert
                String scannerStop = input.next();
                Disciplin disciplin = Disciplin.valueOf(input.next());
                double tid = input.nextDouble();
                String dato = input.next();
                RekordTid rekordTid = new RekordTid(tid, dato);
                String træner = input.next();
                Konkurrence konkurrence = new Konkurrence(navn, år, måned, dag, medlemNR, erAktiv, disciplin, rekordTid);
                konkurrence.setTræner(træner);
                svømmers.add(konkurrence);
            } else {
                Motionist motionist = new Motionist(navn, år, måned, dag, medlemNR, erAktiv);
                svømmers.add(motionist);
            }
        }
        return svømmers;
    }


}
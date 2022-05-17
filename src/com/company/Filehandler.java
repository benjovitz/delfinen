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
        out=new PrintStream(new File("memberFile.csv"));
        for (Svømmer svømmer:svømmers) {
            String navn = svømmer.getName();
            int år = svømmer.getÅr();
            int måned = svømmer.getMåned();
            int dag = svømmer.getDag();
            int medlemsnummer = svømmer.getMedlemsNummer();
            String csvString = navn + ";" +år+";" + måned +";"+ dag + ";" + medlemsnummer;
            out.println(csvString);
            System.out.println("finished writing file");
        }
    }
    public ArrayList<Svømmer> loadRecords() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("memberFile.csv"));
        ArrayList<Svømmer> svømmers = new ArrayList<>();
        while (fileScanner.hasNext()) {
            String fileLine = fileScanner.nextLine();
            Scanner input = new Scanner(fileLine).useDelimiter(";").useLocale(Locale.ENGLISH);
            String navn = input.next();
            int år = input.nextInt();
            int måned = input.nextInt();
            int dag = input.nextInt();
            int medlemNR = input.nextInt();
            Motionist motionist = new Motionist(navn,år,måned,dag,medlemNR);
            svømmers.add(motionist);
        }
        return svømmers;

    }


}

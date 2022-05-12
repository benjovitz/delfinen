package com.company;



import java.io.*;

public class Filehandler {

    private String name;
    private int age;
    private int memNr =  20220;

    private String path = "/Users/oscarstorm/IdeaProjects/delfinen/src/memberFile.csv";

    BufferedReader br;
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

    public void saveRecords(String name, int age){


        try(PrintStream save = new PrintStream(new File("memberFile.csv")))
        {
        String navn = name;
        int alder = age;
        int medlemsnummer = memNr;
        String csvString = navn + ";" + alder + ";" + medlemsnummer;
        save.println(csvString);
        System.out.println("finished writing file");
        }
        catch (FileNotFoundException e)
        {

        }

    }


}

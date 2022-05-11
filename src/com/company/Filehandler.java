package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filehandler {

    private String path = "/Users/oscarstorm/IdeaProjects/delfinen/src/memberFile.csv";

    BufferedReader br;
    private String line = "";

    public void readFile() {

        {
            try {
                br = new BufferedReader(new FileReader(path));

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    System.out.println("name: " + values[0] + " age: " + values[1] + " membernr: " + values[2]);

                    //System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

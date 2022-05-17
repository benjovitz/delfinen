package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;

public class Træner {

    private ArrayList<Svømmer> svømmers = new ArrayList<>();
    private ArrayList<Konkurrence> konkurrences = new ArrayList<>();
    Date date = new Date();

    public void tilføjMedlem(String name, int år, int måned, int dag, int medlemsNummer) {
        if (age < 18) {
            Junior junior = new Junior(name, år, måned, dag, medlemsNummer);
            svømmers.add(junior);
        } else if (age >= 18 || age > 60) {
            Senior senior = new Senior(name, år, måned, dag, medlemsNummer);
            svømmers.add(senior);
        } else {
            Pensionist pensionist = new Pensionist(name, år, måned, dag, medlemsNummer);
            svømmers.add(pensionist);
        }

    }

    public int senesteMedlemsnummer() {
        return svømmers.get(svømmers.size() - 1).getMedlemsnummer();
    }


    public void tilføjKonkurrence(String name, int age, int medlemsNummer) {
        if (age < 18) {
            JuniorKonkurrence juniorKonkurrence = new JuniorKonkurrence(name, age, medlemsNummer, null);
            svømmers.add(juniorKonkurrence);
            konkurrences.add(juniorKonkurrence);
        } else {
            SeniorKonkurrence seniorKonkurrence = new SeniorKonkurrence(name, age, medlemsNummer, null);
            svømmers.add(seniorKonkurrence);
            konkurrences.add(seniorKonkurrence);
        }

    }

    public ArrayList<Svømmer> getArray() {
        return svømmers;
    }

    public void setSvømmers(ArrayList<Svømmer> svømmers) {
        this.svømmers = svømmers;
    }

    public void tilføjSvømmer(Svømmer svømmer) {
        svømmers.add(svømmer);
    }

    public int udregnAlder(int fødselsår, int fødselsmåned, int fødselsdag) {
        int alder = 0;
        if (fødselsmåned < date.getMonth() + 1) {
            alder = date.getYear() + 1900 - fødselsdag - 1;
        } else if (fødselsmåned == date.getMonth()+1) {
            if (fødselsdag < date.getDate()) {
                alder = date.getYear() + 1900 - fødselsdag -1;
            }
        } else {
            alder = date.getYear() + 1900 - fødselsdag;
        }
        return alder;
    }
}
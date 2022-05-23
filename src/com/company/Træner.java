package com.company;

import java.util.*;
import java.time.LocalDate;

public class Træner {

    private String name;
    private ArrayList<Svømmer> svømmers = new ArrayList<>();
    private ArrayList<Konkurrence> konkurrences = new ArrayList<>();
    private ArrayList<RekordTid> konkurrenceTider = new ArrayList<>();
    private Date date = new Date();


    public void tilføjMedlem(String name, int år, int måned, int dag, int medlemsNummer) {
        Motionist motionist = new Motionist(name, år, måned, dag, medlemsNummer, true);
        svømmers.add(motionist);
    }

    public int senesteMedlemsnummer() {
        if (svømmers.size() == 0) {
            return 0;
        } else {
            return svømmers.get(svømmers.size() - 1).getMedlemsnummer();
        }
    }


    public void tilføjKonkurrence(String name, int år, int måned, int dag, int medlemsNummer, Disciplin disciplin) {
        RekordTid rekordTid = new RekordTid(0, "N/A");
        Konkurrence konkurrence = new Konkurrence(name, år, måned, dag, medlemsNummer, true, disciplin, rekordTid);
        konkurrence.setTræner("N/A");
        svømmers.add(konkurrence);
    }

    public void viewArray() {
        System.out.println(svømmers);
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
            alder = date.getYear() + 1900 - fødselsår;
        } else if (fødselsmåned == date.getMonth() + 1) {
            if (fødselsdag <= date.getDate()) {
                alder = date.getYear() + 1900 - fødselsår;
            }
        } else {
            alder = date.getYear() + 1900 - fødselsår - 1;
        }
        return alder;
    }

    public int udregnkontingent(int alder, boolean erAktiv) {
        if (!erAktiv) {
            return 500;
        } else {
            if (alder < 18) {
                return 1000;
            } else if (alder >= 60) {
                return 1200;
            } else {
                return 1600;
            }
        }
    }

    public Svømmer findSvømmer(int medlemsnummer) {
        for (Svømmer svømmer : svømmers) {
            if (svømmer.getMedlemsnummer() == medlemsnummer) {
                return svømmer;
            }
        }
        return null;
    }

    public void nyRekord(Konkurrence konkurrence, double tid, String dato) {
        RekordTid rekordTid = new RekordTid(tid, dato);
        konkurrence.setRekordTid(rekordTid);
    }

    public void seRekord(Konkurrence svømmer) {
        System.out.println(svømmer.getRekordTid());
    }

    public void tilføjKonkurrencetid(double time, int placering, String stævne, int medlemsnummer, Disciplin disciplin) {
        konkurrenceTider.add(new RekordTid(time, placering, stævne, medlemsnummer, disciplin));
    }

    public ArrayList<RekordTid> getKonkurrenceTider() {
        return konkurrenceTider;
    }

    public void setKonkurrenceTider(ArrayList<RekordTid> konkurrenceTider) {
        this.konkurrenceTider = konkurrenceTider;
    }


    public void fjernMedlem(Svømmer svømmer) {
        svømmers.remove(svømmer);
    }


    public ArrayList<Konkurrence> getKonkurrences() {
        return konkurrences;
    }

    public void findRekorder() {
        ArrayList<RekordTid> tmp = konkurrenceTider;
        tmp.sort(RekordTid::compareTo);
        System.out.println(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            int medlem = tmp.get(i).getMedlemsnummer();
            for (int j = tmp.size()-1; j > i; j--) {
                if(medlem==tmp.get(j).getMedlemsnummer()){
                    tmp.remove(tmp.get(j));
                }
            }
        }
        System.out.println(tmp);

        /*ArrayList<RekordTid> tmp = new ArrayList<>();
        for (Konkurrence konkurrence : konkurrences) {
            int medlem = konkurrence.getMedlemsnummer();
            for (RekordTid rekordTid : konkurrenceTider) {
                if (medlem == rekordTid.getMedlemsnummer()) {
                    tmp.add(rekordTid);
                }
            }
        }
        System.out.println(tmp);
    }*/
    }
}


package com.company;

import java.util.ArrayList;

public class Træner {

private String name;
private ArrayList<Svømmer> svømmers = new ArrayList<>();
private ArrayList<Konkurrence> konkurrences = new ArrayList<>();


    public void tilføjMedlem(String name,int age,int medlemsNummer) {
        if(age<18){
            Junior junior = new Junior(name,age,medlemsNummer);
            svømmers.add(junior);
        } else if (age>=18||age>60){
            Senior senior = new Senior(name,age,medlemsNummer);
            svømmers.add(senior);
        } else{
            Pensionist pensionist = new Pensionist(name,age,medlemsNummer);
            svømmers.add(pensionist);
        }

    }

    public int senesteMedlemsnummer() {
        return svømmers.get(svømmers.size()-1).getMedlemsnummer();
    }


    public void tilføjKonkurrence(String name, int age, int medlemsNummer){
        if(age<18){
            JuniorKonkurrence juniorKonkurrence = new JuniorKonkurrence(name,age,medlemsNummer,null);
            svømmers.add(juniorKonkurrence);
            konkurrences.add(juniorKonkurrence);
        } else{
            SeniorKonkurrence seniorKonkurrence = new SeniorKonkurrence(name,age,medlemsNummer,null);
            svømmers.add(seniorKonkurrence);
            konkurrences.add(seniorKonkurrence);
        }

    }

    public void viewArray(){
        System.out.println(svømmers);

    }
    public ArrayList<Svømmer> getArray(){
        return svømmers;
    }

    public void setSvømmers(ArrayList<Svømmer> svømmers) {
        this.svømmers = svømmers;
    }

    public void tilføj(Svømmer svømmer){
        svømmers.add(svømmer);
}


}
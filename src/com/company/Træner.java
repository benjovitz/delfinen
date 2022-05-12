package com.company;

import java.util.ArrayList;

public class Træner {

private String name;
private ArrayList<Svømmer> svømmers = new ArrayList<>();
private ArrayList<Konkurrence> konkurrences = new ArrayList<>();


    public void tilføjMedlem(String name,int age,int medlemsNummer) {
        if(age<18){
            Junior junior = new Junior(name,age,medlemsNummer,1000);
            svømmers.add(junior);
        } else if (age>=18||age>60){
            Senior senior = new Senior(name,age,medlemsNummer,1600);
            svømmers.add(senior);
        } else{
            Pensionist pensionist = new Pensionist(name,age,medlemsNummer,1200);
            svømmers.add(pensionist);
        }

    }


    public void tilføjKonkurrence(String name, int age, int medlemsNummer){
        if(age<18){
            JuniorKonkurrence juniorKonkurrence = new JuniorKonkurrence(name,age,medlemsNummer,1000,null);
            svømmers.add(juniorKonkurrence);
            konkurrences.add(juniorKonkurrence);
        } else{
            SeniorKonkurrence seniorKonkurrence = new SeniorKonkurrence(name,age,medlemsNummer,1600,null);
            svømmers.add(seniorKonkurrence);
            konkurrences.add(seniorKonkurrence);
        }

    }

    public void viewArray(){
        System.out.println(svømmers);

    }




}
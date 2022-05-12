package com.company;

public class SeniorKonkurrence extends Konkurrence{

    public SeniorKonkurrence(String name, int age, int medlemsNummer, RekordTid rekortTid) {
        super(name, age, medlemsNummer, rekortTid);
        kontingent=1600;
    }
}

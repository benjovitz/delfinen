package com.company;

public class JuniorKonkurrence extends Konkurrence {

    public JuniorKonkurrence(String name, int age, int medlemsNummer, RekordTid rekortTid) {
        super(name, age, medlemsNummer, rekortTid);
        kontingent=1000;
    }
}

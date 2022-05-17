package com.company;

public class SeniorKonkurrence extends Konkurrence{

    public SeniorKonkurrence(String name, int år,int måned,int dag, int medlemsNummer, RekordTid rekortTid) {
        super(name, år,måned,dag, medlemsNummer, rekortTid);
        kontingent=1600;
    }
}

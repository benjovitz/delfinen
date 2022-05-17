package com.company;

public class Konkurrence extends Svømmer {

    private RekordTid rekordTid;

    public Konkurrence(String name, int år,int måned,int dag, int medlemsNummer, RekordTid rekordTid) {
        super(name,år,måned,dag, medlemsNummer);
        this.rekordTid=rekordTid;
    }
}

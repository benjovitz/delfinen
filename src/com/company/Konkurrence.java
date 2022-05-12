package com.company;

public abstract class Konkurrence extends Svømmer {
    private RekordTid rekordTid;

    public Konkurrence(String name, int age, int medlemsNummer, RekordTid rekordTid) {
        super(name, age, medlemsNummer);
        this.rekordTid=rekordTid;
    }
}

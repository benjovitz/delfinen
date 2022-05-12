package com.company;

public abstract class Konkurrence extends Svømmer {
    private RekortTid rekortTid;

    public Konkurrence(String name, int age, int medlemsNummer,RekortTid rekortTid) {
        super(name, age, medlemsNummer);
        this.rekortTid=rekortTid;
    }
}

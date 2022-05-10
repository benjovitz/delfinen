package com.company;

public abstract class Konkurrence extends Svømmer {
    private RekortTid rekortTid;

    public Konkurrence(String name, int age, int medlemsNummer, int kontingent,RekortTid rekortTid) {
        super(name, age, medlemsNummer, kontingent);
        this.rekortTid=rekortTid;
    }
}

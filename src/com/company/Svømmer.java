package com.company;

public abstract class Svømmer {
    protected String name;
    protected int  age;
    protected int medlemsNummer;
    protected int kontingent;

    public Svømmer(String name,int age, int medlemsNummer, int kontingent) {
        this.name=name;
        this.age=age;
        this.medlemsNummer=medlemsNummer;
        this.kontingent=kontingent;
    }
}

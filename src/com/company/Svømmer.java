package com.company;

public abstract class Svømmer {
    protected String name;
    protected int  age;
    private int medlemsNummer;
    protected int kontingent;
    private boolean erAktiv = true;

    public Svømmer(String name,int age, int medlemsNummer) {
        this.name=name;
        this.age=age;
        this.medlemsNummer=medlemsNummer;
    }
    public String toString(){
        return name+" "+age+" "+medlemsNummer+" "+kontingent;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMedlemsNummer() {
        return medlemsNummer;
    }

    public int getKontingent() {
        return kontingent;
    }

    public int getMedlemsnummer(){
        return medlemsNummer;
    }

}
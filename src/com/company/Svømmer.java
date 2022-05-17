package com.company;

public abstract class Svømmer {
    protected String name;
    protected int år;
    protected int måned;
    protected int dag;
    private int medlemsNummer;
    protected int kontingent;
    private boolean erAktiv = true;

    public Svømmer(String name,int år,int måned,int dag, int medlemsNummer) {
        this.name=name;
        this.år=år;
        this.måned=måned;
        this.dag=dag;
        this.medlemsNummer=medlemsNummer;
    }
    public String toString(){
        return name+" "+år+" "+måned+" "+dag+" "+medlemsNummer+" "+kontingent;
    }

    public String getName() {
        return name;
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
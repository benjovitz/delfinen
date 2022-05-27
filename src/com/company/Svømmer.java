package com.company;

public abstract class Svømmer {
    protected String name;
    protected int år;
    protected int måned;
    protected int dag;
    private int medlemsNummer;
    protected int kontingent;
    private boolean erAktiv;
    private boolean harBetalt = true;

    public Svømmer(String name, int år, int måned, int dag, int medlemsNummer, boolean erAktiv,boolean harBetalt) {
        this.name = name;
        this.år = år;
        this.måned = måned;
        this.dag = dag;
        this.medlemsNummer = medlemsNummer;
        this.erAktiv = erAktiv;
        this.harBetalt=harBetalt;
    }

    public String toString() {
        return name + " " + år + " " + måned + " " + dag + " " + medlemsNummer + " " + erAktiv + " " + kontingent;
    }

    public String getName() {
        return name;
    }

    public int getKontingent() {
        return kontingent;
    }

    public int getMedlemsnummer() {
        return medlemsNummer;
    }

    public int getÅr() {
        return år;
    }

    public int getMåned() {
        return måned;
    }

    public int getDag() {
        return dag;
    }

    public void setErAktiv(boolean erAktiv) {
        this.erAktiv = erAktiv;
    }

    public boolean getErAktiv() {
        return erAktiv;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean getHarbetalt() {
        return harBetalt;
    }

    public void setHarBetalt(boolean harBetalt) {
        this.harBetalt = harBetalt;
    }
}

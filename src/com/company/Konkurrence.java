package com.company;

import java.io.PrintStream;

public class Konkurrence extends Svømmer {

    private RekordTid rekordTid;
    private Disciplin disciplin;
    private String træner;

    public Konkurrence(String name, int år,int måned,int dag, int medlemsNummer,boolean erAktiv,Disciplin disciplin, RekordTid rekordTid) {
        super(name,år,måned,dag, medlemsNummer,erAktiv);
        this.disciplin=disciplin;
        this.rekordTid=rekordTid;
    }

    public void setRekordTid(RekordTid rekordTid) {
        this.rekordTid = rekordTid;
    }

    public void setDisciplin(Disciplin disciplin) {
        this.disciplin = disciplin;
    }

    public RekordTid getRekordTid() {
        return rekordTid;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }

    public void setTræner(String træner) {
        this.træner = træner;
    }

    public String getTræner() {
        return træner;
    }
}

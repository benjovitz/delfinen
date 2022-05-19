package com.company;

public class Konkurrence extends Svømmer {

    private RekordTid rekordTid;
    private Disciplin disciplin;

    public Konkurrence(String name, int år,int måned,int dag, int medlemsNummer,Disciplin disciplin, RekordTid rekordTid) {
        super(name,år,måned,dag, medlemsNummer);
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
}

package com.company;

public class RekordTid implements Comparable<RekordTid>{
    private double time;
    private String dato;
    private String stævne;
    private int placering;
    private int medlemsnummer;
    private Disciplin disciplin;

    public RekordTid(double time, int placering, String stævne, int medlemsnummer,Disciplin disciplin){
        this.time = time;
        this.placering = placering;
        this.stævne = stævne;
        this.medlemsnummer = medlemsnummer;
        this.disciplin=disciplin;
    }

    public RekordTid(double time, String dato){
        this.time = time;
        this.dato = dato;
    }

    public String toString(){
        if (dato == null){
            return  "Tid: " + time + " Placering: " + placering + " Stævne: " + stævne + " Medlemsnummer: " + medlemsnummer + " Disciplin: " +disciplin+"\n";
        } else {
            return time + " " + dato + '\n';
        }
    }

    public double getTime() {
        return time;
    }

    public String getDato() {
        return dato;
    }

    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    public int getPlacering() {
        return placering;
    }

    public String getStævne() {
        return stævne;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }


    @Override
    public int compareTo(RekordTid rekordTid) {
        boolean tid = sorter(rekordTid);
        if(tid){
            return 1;
        }else {
            return -1;
        }
    }
    public boolean sorter(RekordTid rekordTid){
    if(rekordTid.getTime()<this.time){
        return true;
    }else {
        return false;
    }

    }
}

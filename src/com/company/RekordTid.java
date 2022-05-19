package com.company;

public class RekordTid {
    private double time;
    private String dato;
    private String stævne;
    private int placering;
    private int medlemsnummer;

    public RekordTid(double time, int placering, String stævne, int medlemsnummer){
        this.time = time;
        this.placering = placering;
        this.stævne = stævne;
        this.medlemsnummer = medlemsnummer;
    }

    public RekordTid(double time, String dato){
        this.time = time;
        this.dato = dato;
    }

    public String toString(){
        if (dato == null){
            return  "Tid: " + time + " Placering: " + placering + " Stævne: " + stævne + " Medlemsnummer: " + medlemsnummer + '\n';
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
}

package com.company;

public class RekordTid {
    private double time;
    private String dato;
    private String stævne;
    private int placering;

    public RekordTid(int time, int placering, String stævne) {
        this.time = time;
        this.placering = placering;
        this.stævne = stævne;
    }

    public RekordTid(double time, String dato) {
        this.time = time;
        this.dato = dato;
    }

    public String toString() {
        return time + " " + dato;
    }

    public double getTime() {
        return time;
    }

    public String getDato() {
        return dato;
    }
}

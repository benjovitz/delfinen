package com.company;

public class Pensionist extends Svømmer {

    public Pensionist(String name,int år,int måned,int dag, int medlemsNummer){
        super(name,år,måned,dag, medlemsNummer);
        kontingent=1200;
    }
}
